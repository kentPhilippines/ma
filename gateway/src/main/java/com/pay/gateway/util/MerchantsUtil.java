package com.pay.gateway.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.WithdrawalsOrder;
import com.pay.gateway.service.AccountFeeService;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.MerchantsService;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.service.RunningOrderService;

/**
 * <p>代付全局工具类</p>
 * @author K
 *
 */
@Service
public class MerchantsUtil {
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	RunningOrderService RunningOrderServiceImpl;
	@Autowired
	AccountService accountServiceImpl;
	@Autowired
	AccountFeeService accountFeeServiceImpl;
	@Autowired
	BankCardService BankCardServiceImpl;
	@Autowired
	MerchantsService merchantsServiceImpl;
	Logger log = LoggerFactory.getLogger(MerchantsUtil.class);
	@Transactional
	public synchronized boolean updataOrderStatus(String orderIdAll,Integer runStatus) {
		log.info("|---------【进入订单修改核心处理类，捕获全局订单编号："+orderIdAll+"】");
		 //修改訂單狀態
		 boolean flag = orderServiceImpl.updataOrderStatusByAssociatedId(orderIdAll);
		 DealOrder dealOrder = orderServiceImpl.findOrderByOrderAll(orderIdAll);
		 //生成流水 總共會生成2筆流水
		 boolean runAmount = RunningOrderServiceImpl.createDealRun(dealOrder,runStatus);//交易流水
		 boolean runFee = RunningOrderServiceImpl.createDealRunFee(dealOrder,runStatus);//費率流水
		 if(!(runAmount || runFee)) 
				return false;
		 //修改賬戶金額變動
		 Account account = accountServiceImpl.findAccountByAppId(dealOrder.getOrderAccount());
		 AccountFee accountFee = accountFeeServiceImpl.findAccountFeeByFeeId(Integer.valueOf(dealOrder.getRetain2()));
		 boolean flagAccount = updataAccountRunAmount(account,accountFee,dealOrder);
		 if(flagAccount && runFee && runAmount && flag)
			 return true;
		return false;
	}
	private boolean updataAccountRunAmount(Account account, AccountFee accountFee, DealOrder dealOrder) {
		return false;
	}
	
	
	/**
	 * <p>根据全局订单生成代付流水，并扣除账户资金为冻结</p>
	 * @param orderId		全局订单表
	 * @return
	 */
	public boolean updataMerchants(String orderIdAll,Integer runStatus) {
		log.info("|---------【进入订单修改核心处理类，捕获全局订单编号："+orderIdAll+"】");
		OrderAll orderAll = orderServiceImpl.findOrderAllByOrderAll(orderIdAll);
		log.info("|---------【进入订单修改核心处理类，全局订单获取正常，数据id为："+orderAll.getId()+"，订单编号为："+orderAll.getOrderId()+"】");
		WithdrawalsOrder order = merchantsServiceImpl.findMerchantsOrderByOrderAllId(orderAll.getOrderId());
		log.info("|---------【进入订单修改核心处理类，代付订单获取正常，数据id为："+order.getId()+"，订单编号为：】"+order.getOrderId()+"");
		log.info("【开始生成代付流水】");
		boolean runflag = RunningOrderServiceImpl.createMerchantsRun(order, runStatus);
		boolean runFeeflag = RunningOrderServiceImpl.createMerchantsFeeRun(order, runStatus);
		log.info("----【代付金额生成结果为："+runflag+"，代付手续费生成流水结果为："+runFeeflag+"，开始开始冻结账户】-----");
		boolean accountAmount = updataAccountRunAmount(order);
		if(runflag && runFeeflag && accountAmount) {
			return true;
		}
		return false;
	}
	/**
	 * <p>根据代付订单数据创建账户资金变动</p>
	 * @param order
	 * @return
	 */
	private boolean updataAccountRunAmount(WithdrawalsOrder order) {
		log.info("|---------【进入资金变动的核心方法】");
		Account account = accountServiceImpl.findAccountByAppId(order.getOrderAccount());
		/**
		 * ################################
		 * 	商户账户代付资金变动逻辑
		 * 1,减少可提现现金的  账目
		 * 2,减少总余额的账目
		 */
		BigDecimal actualAmount = order.getActualAmount();//实际到账金额
		BigDecimal withdrawalsAmount = order.getWithdrawalsAmount();//商户提交的代付总金额
		BigDecimal withdrawalsFee = order.getWithdrawalsFee();//代付的手续费
		log.info("|---------【当前用户："+order.getOrderAccount()+"代付的实际到账金额为："+actualAmount+"】");
		log.info("|---------【当前用户："+order.getOrderAccount()+"代付的总提现金额为："+withdrawalsAmount+"】");
		log.info("|---------【当前用户："+order.getOrderAccount()+"代付的手续费金额为："+withdrawalsFee+"】");
		BigDecimal cashBalance = account.getCashBalance();
		BigDecimal accountBalance = account.getAccountBalance();
		accountBalance = accountBalance.subtract(withdrawalsAmount);
		cashBalance = cashBalance.subtract(withdrawalsAmount);
		boolean updataAccountByAcoountId = accountServiceImpl.updataAccountByAcoountId(account);
		return updataAccountByAcoountId;
	}
}
