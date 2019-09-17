package com.pay.gateway.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.exception.OtherErrors;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.ExceptionOrderEntity;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.WithdrawalsOrder;
import com.pay.gateway.entity.WithdrawalsRecord;
import com.pay.gateway.service.AccountFeeService;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.ExceptionOrderService;
import com.pay.gateway.service.MerchantsService;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.DealNumber;
import com.pay.gateway.util.IpUtil;
import com.pay.gateway.util.JsonResult;
import com.pay.gateway.util.MerchantsUtil;
import com.pay.gateway.util.SendUtil;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import io.lettuce.core.dynamic.annotation.Param;


@Controller
@RequestMapping("/merchants")
public class MerchantsContorller {
	@Autowired
	SendUtil sendUtil;
	@Autowired
	MerchantsService merchantsServiceImpl;
	@Autowired
	AccountService accountServiceImpl;
	@Autowired
	ExceptionOrderService exceptionOrderServiceImpl;
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	AccountFeeService accountFeeServiceImpl;
	@Autowired
	MerchantsUtil merchantsUtil;
	/**
	 * <p>这里要进行加密传输,参数全部要进行rsa双向加密</p>
	 * @param request
	 * @return
	 */
	@PostMapping("/amount")	
	@ResponseBody
	@Transactional
	public JsonResult amount(HttpServletRequest request) {
		HashMap<String, String> decryptionParam;
		try {
			decryptionParam = sendUtil.decryptionParam(request);
		} catch (Exception e) {
			return JsonResult.buildFailResult("远程请求参数解密异常");
		}
		String userId = decryptionParam.get("userId");
		String userName = decryptionParam.get("userName");
		String accountId = decryptionParam.get("accountId");
		String backCard = decryptionParam.get("backCard");
		String amount = decryptionParam.get("amount");
		String ipAddr = decryptionParam.get("ipAddr");
		List<AccountFee>  accountFeeList = accountFeeServiceImpl.findAccountFeeBy(accountId,Common.FEE_STATUS1);//理论上可以查询到一条费率状态
		if(CollUtil.isEmpty(accountFeeList)) {
			return JsonResult.buildFailResult("商户号代付费率未分配");
		}
		AccountFee accountFee = CollUtil.getFirst(accountFeeList);	
		OrderAll orderAll =  new OrderAll();
		orderAll.setOrderId(DealNumber.GetAllOrder());
		orderAll.setOrderAccount(accountId);
		orderAll.setOrderAmount(amount.toString());//目前这里的金额就是用户提交的金额 和我们实际支付的金额是不同的,但是我们用订单号相关联就不会存在金额不一样的问题
		orderAll.setOrderIp(ipAddr);
		orderAll.setOrderType(Common.BANKORDERALL_WIT);
		orderAll.setRetain2(accountFee.getId().toString());
		orderAll.setRetain5(accountFee.getWithdrawal());
		Boolean flag = orderServiceImpl.addOrderAll(orderAll);
		if(!flag) {
			throw new OtherErrors("全局生成订单异常");
		}
		/**
		 * <p>验证提现商户号是否有足够的钱</p>
		 */
		Account findAccountByAppId = accountServiceImpl.findAccountByAppId(accountId);
		BigDecimal cashBalance = findAccountByAppId.getCashBalance();
		BigDecimal cash = new BigDecimal(amount);
		if(cashBalance.compareTo(cash) == -1){
			String msg = "当前商户号余额不够";
			addExceptionOrder(decryptionParam,orderAll,msg);
			return JsonResult.buildFailResult(msg);
		}
		/**
		 * <p>生成提现记录表数据,状态为处理中,审核人为系统审核,</p>
		 */
		WithdrawalsRecord record = addWithdrawalsRecord(decryptionParam,orderAll,"当前申请正常系统正在处理中",true);
		addWithdrawalsOrder(record,accountFee,orderAll);
		boolean updataMerchants = merchantsUtil.updataMerchants(orderAll.getOrderId(),Common.RUN_STATUS_1);
		if(updataMerchants) {
			return JsonResult.buildSuccessMessage("申请提现成功，请等待业务人员审核");
		}
		boolean flag2 = merchantsServiceImpl.updataWithdrawalsRecord(orderAll.getOrderId(),Common.DPAY_STATUS_ER);
		boolean flag3 = merchantsServiceImpl.updataWithdrawalsOrder(orderAll.getOrderId(),Common.WI_DPAY_STATUS_ER);
		if(flag2 && flag3) {
			return JsonResult.buildFailResult("申请提现失败");
		}else {//存在数据修改失败的情况,回滚
			throw new OtherErrors("异常订单生成发生异常");
		}
	}
	
	/**
	 * <p>生成代付订单表并返回代付订单</p>
	 * @param record
	 * @param accountFee
	 * @param orderAll 
	 */
	private void addWithdrawalsOrder(WithdrawalsRecord record, AccountFee accountFee, OrderAll orderAll) {
		WithdrawalsOrder order = new WithdrawalsOrder();
		order.setOrderId(DealNumber.GetWitOrder());
		order.setAssociatedId(orderAll.getOrderId());
		order.setBankCard(record.getRetain1());
		order.setOrderStatus(Common.WI_DPAY_STATUS_WI);
		String withdrawal = accountFee.getWithdrawal();//这里取出来的全部是2块
		BigDecimal a = new BigDecimal(withdrawal);
		BigDecimal amount = record.getAmount();
		BigDecimal subtract = amount.subtract(a);
		order.setActualAmount(subtract);//代付实际到账金额
		order.setWithdrawalsFee(a);
		order.setWithdrawalsAmount(amount);
		order.setOrderType(Common.WI_DPAY_TYPE_WI);
		order.setOrderGenerationIp(record.getIp());
		order.setDealChannel(accountFee.getAccountChannel());
		boolean flag = merchantsServiceImpl.addWithdrawalsOrder(order);
		if(!flag) {
			 throw new OtherErrors("异常订单生成发生异常");
		}
	}
	/**
	 * <p>异常订单表生成</p>
	 * @param decryptionParam	代付参数
	 * @param orderAll 			全局订单
	 * @param msg 
	 */
	private void addExceptionOrder(HashMap<String, String> decryptionParam, OrderAll orderAll, String msg) {
		String accountId = decryptionParam.get("accountId");
		String amount = decryptionParam.get("amount");
		String ipAddr = decryptionParam.get("ipAddr");
		ExceptionOrderEntity exceopt = new ExceptionOrderEntity();
		exceopt.setExceptStatus(Common.EXCEPT_STATUS_SYS);
		exceopt.setExceptType(Common.EXCEPT_TYPE_DEAL);
		exceopt.setOrderExceptId(DealNumber.GetExceOrder());
		exceopt.setOrderId(orderAll.getOrderId());
		exceopt.setOrderAccount(accountId);
		exceopt.setExplain(msg);
		exceopt.setOrderGenerationIp(ipAddr);
		exceopt.setOperation("SYS");
		exceopt.setExceptOrderAmount(amount);
		boolean flag = exceptionOrderServiceImpl.addExceptionOrder(exceopt);
		if(!flag) {
			 throw new OtherErrors("异常订单生成发生异常");
		}
		addWithdrawalsRecord( decryptionParam, orderAll, msg,false);
	}
	/**
	 * <p>生成提现记录表</p>
	 * @param decryptionParam
	 * @param orderAll
	 * @param msg
	 */
	private WithdrawalsRecord addWithdrawalsRecord(HashMap<String, String> decryptionParam, OrderAll orderAll, String msg,boolean flag) {
		String accountId = decryptionParam.get("accountId");
		String amount = decryptionParam.get("amount");
		String ipAddr = decryptionParam.get("ipAddr");
		String backCard = decryptionParam.get("backCard");
		WithdrawalsRecord wr = new WithdrawalsRecord();
		wr.setAccountId(accountId);
		wr.setAmount(new BigDecimal(amount));
		wr.setApprover("SYS");
		wr.setAssociatedId(orderAll.getOrderId());
		wr.setIp(ipAddr);
		wr.setNote(msg);
		wr.setMerchantsStatus(flag?Common.DPAY_STATUS_WI:Common.DPAY_STATUS_ER);
		wr.setRetain1(backCard);
		boolean flag1 = merchantsServiceImpl.addWithdrawalsRecord(wr);
		if(!flag1) {
			throw new OtherErrors("提现记录订单生成发生异常");
		}
		return wr;
	}
}
