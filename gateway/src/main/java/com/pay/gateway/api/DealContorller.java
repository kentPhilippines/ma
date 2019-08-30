package com.pay.gateway.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pay.gateway.channel.H5ailiPay.service.H5aliPayService;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.service.PayService;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.entity.ChannelFee;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;
import com.pay.gateway.service.AccountFeeService;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.ChannelService;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.DealNumber;
import com.pay.gateway.util.IpUtil;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>用户交易</p>
 * @author K
 *<li>1,当前交易是否超额</li>
 *<li>2,查询当前费率是否存在</li>
 *<li>3,根据费率计算利润</li>
 *<li>4,生成订单和相应订单数据</li>
 *<li>5,填充用户数据修改用户金额</li>
 *<li>6,请求上游渠道</li>
 */
@Controller
@RequestMapping("/deal")
public class DealContorller {
	private static final String ApiService = null;
	@Autowired
	AccountService accountServiceImpl;
	@Autowired
	AccountFeeService accountFeeServiceImpl;
	@Autowired
	ChannelService channelServiceImpl;
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	H5aliPayService H5aliPayServiceImpl;
	Logger log = LoggerFactory.getLogger(DealContorller.class);
	@PostMapping("/payH5Ali")
	@Transactional
	public void payH5Ali(Deal deal ,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		log.info("------------------------------【进入支付宝H5模式交易处理】------------------------------");
		 String appid = request.getParameter("appid");
		String orderid = request.getParameter("orderid");
		String notifyurl = request.getParameter("notifyurl");
		String passcode = request.getParameter("passcode");
		String callbackurl = request.getParameter("callbackurl");
		String amount1 = request.getParameter("amount");
		if(StrUtil.isBlank(appid) || StrUtil.isBlank(orderid) ||StrUtil.isBlank(notifyurl) ||StrUtil.isBlank(passcode)  || StrUtil.isBlank(amount1)) {
			log.info("------------------------------【必传参数为空】------------------------------");
			response.getWriter().write("15034--必传参数为空");
			return;
		}
		 Account account = accountServiceImpl.findAccountByAppId(appid);
		OrderAll order = orderServiceImpl.findOrderByTradeId(appid,orderid);
		if(ObjectUtil.isNotNull(order)) {
			log.info("------------------------------【14004:外部商户订单号重复】------------------------------");
			response.getWriter().write("14004--外部商户订单号重复");
			return;
		}
		BigDecimal dayDealAmountMax = account.getDayDealAmountMax();//交易最大金额区间
		BigDecimal dayDealAmountMin = account.getDayDealAmountMin();//交易最小金额区间
		BigDecimal sumDealToDayAmount = account.getSumDealToDayAmount();//当天累计交易额度
		BigDecimal amount = new BigDecimal(amount1);
		amount = amount.divide(new BigDecimal(100));
		if(amount.compareTo(dayDealAmountMax) == 1) {
			log.info("------------------------------【14001:当前交易额度超过该账号最大交易额度】------------------------------");
			response.getWriter().write("14001--当前交易额度超过当天最大交易额度");
			return;
		}
		if(amount.compareTo(dayDealAmountMin) == -1 ) {
			log.info("------------------------------【14002:当前交易额度小于该账号最小交易额度】------------------------------");
			response.getWriter().write("14002--当前交易额度小于该账号最小交易额度");
			return;
		}
		amount = amount.add(sumDealToDayAmount);
		if(amount.compareTo(dayDealAmountMin) == -1 ) {
			log.info("------------------------------【14003:当日交易累计已超过该账号最大交易额度，当日累计交易："+sumDealToDayAmount+"，交易额度："+dayDealAmountMax+"，当前交易金额："+amount1+"分】------------------------------");
			response.getWriter().write("14003--当日交易累计已超过该账号最大交易额度，当日累计交易："+sumDealToDayAmount+"，交易额度："+dayDealAmountMax+"，当前交易金额："+amount1+"分");
			return;
		}
		List<AccountFee>  accountFeeList = accountFeeServiceImpl.findAccountFeeBy(appid,Common.FEE_STATUS1);//理论上可以查询到一条费率状态
		if(CollUtil.isEmpty(accountFeeList)) {
			log.info("------------------------------【15001:当前商户账户费率未配置或费率状态未开通】------------------------------");
			response.getWriter().write("15001:当前商户账户费率未配置或费率状态未开通");
			return;
		}
		AccountFee accountFee = CollUtil.getFirst(accountFeeList);	
		log.info("---------------------------------【当前费率为:"+accountFee.getAccountFee()+"，当前费率成本为："+accountFee.getAccountCost()+"】---------------------------------");
		log.info("---------------------------------【当前渠道编号为:"+accountFee.getAccountChannel()+"，当前产品类型编号为："+accountFee.getChannelProduct()+"】---------------------------------");
		String channel  = "";
		ChannelFee channelFee = channelServiceImpl.findChanenlFeeByChannelNo(accountFee.getAccountChannel(),accountFee.getChannelProduct());
		channel = channelFee.getRouting();
		if(StrUtil.isBlank(channel)) {
			log.info("------------------------------【15002:当前商户账户渠道路由未开通】------------------------------");
			response.getWriter().write("15002:当前商户账户渠道路由未开通");
			return;
		}
		try {
			String ipAddr = IpUtil.getIpAddr(request);
			deal.setAmount(amount.toString());
			deal.setAppid(appid);
			deal.setOrderid(orderid);
			deal.setIp(ipAddr);
			OrderAll orderAll =  new OrderAll();
			orderAll.setOrderId(DealNumber.GetAllOrder());
			orderAll.setOrderAccount(appid);
			orderAll.setOrderAmount(amount.toString());//目前这里的金额就是用户提交的金额 和我们实际支付的金额是不同的,但是我们用订单号相关联就不会存在金额不一样的问题
			orderAll.setOrderIp(IpUtil.getIpAddr(request));
			orderAll.setOrderType(Common.BANKORDERALL_DEAL);
			orderAll.setRetain1(orderid);
			Boolean flag = orderServiceImpl.addOrderAll(orderAll);
			if(!flag) {
				log.info("------------------------------【14005:订单生成异常】------------------------------");
				response.getWriter().write("14005:订单生成异常");
				return;
			}
			deal.setOrderNo(orderAll.getOrderId());
			PayService api  = H5aliPayServiceImpl; // (PayService)Class.forName(channel).newInstance();//不同的渠道信息   这里会生成不同是是实现类
			ResultDeal resultDeal = api.deal(deal,account,accountFee,orderAll);
			if(!Common.RESPONSE_STATUS_SU.equalsIgnoreCase(resultDeal.getCod())) {
				log.info("------------------------------【14004:交易失败"+resultDeal.getMsg()+"】------------------------------");
				response.getWriter().write("14004:交易失败"+resultDeal.toString());
				return;
			}
			log.info("------------------------------【转发到："+resultDeal.getReturnUrl()+"】------------------------------");
			request.getRequestDispatcher(resultDeal.getReturnUrl()).forward(request, response);//自己的二维码信息到订单信息里查找
		}  catch (ServletException e) {
			response.getWriter().write("11111:系统异常");
			log.info("------------------------------【11111:转发到H5付款页面失败】------------------------------");
			return;
		}
	}
	

}
