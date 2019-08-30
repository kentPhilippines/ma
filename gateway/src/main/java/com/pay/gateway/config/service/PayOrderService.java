package com.pay.gateway.config.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pay.gateway.api.DealContorller;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.DealNumber;

import cn.hutool.core.util.StrUtil;

/**
 *	<p>交易订单操作类</p>
 * @author ADMIN
 *
 */
public abstract class PayOrderService implements PayService{
	Logger log = LoggerFactory.getLogger(PayOrderService.class);
	@Autowired
	OrderService OrderServiceImpl;
	protected String tradeId;//外部订单号
	protected BigDecimal amount;//交易金额
	protected String appid;//商户号
	String orderType;//交易订单
	String orderGenerationIp;//外部ip
	String dealCardId;//交易银行
	String dealChannel;//交易渠道
	OrderAll orderAll;//全局订单
	AccountFee accountFee;//商户手续费
	Account account;//账户信息
	/**
	 * <p>生成订单逻辑</p>
	 * <li>1,</li>
	 * 
	 * @return
	 */
	public Boolean dealOrder() {
		DealOrder dealOrder = new DealOrder();
		String fee = accountFee.getAccountFee();
		BigDecimal dealFee = amount.multiply(new BigDecimal(fee));
		dealOrder.setOrderId(DealNumber.GetDealOrder());
		dealOrder.setAssociatedId(orderAll.getOrderId());
		dealOrder.setOrderStatus(Common.ORDERDEASTATUS_T);//订单处理中
		dealOrder.setDealAmount(amount);//交易金额
		dealOrder.setDealFee(dealFee);//交易手续费
		dealOrder.setActualAmount(amount.subtract(dealFee));//实际到账金额
		dealOrder.setOrderType(Common.ORDERDEALTYP_DEAL);//订单为交易订单类型
		dealOrder.setOrderAccount(appid);
		dealOrder.setExternalOrderId(tradeId);
		dealOrder.setOrderGenerationIp(orderGenerationIp);
		if(StrUtil.isNotBlank(dealCardId))//只有使用自己渠道的时候该值才存在
			dealOrder.setDealCardId(dealCardId);
		dealOrder.setDealChannel(dealChannel);
		log.info("---【订单填充时数据："+dealOrder.toString()+"】------");
		Boolean  falg = OrderServiceImpl.addDealOrder(dealOrder);
		return falg;
	}
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public OrderService getOrderServiceImpl() {
		return OrderServiceImpl;
	}
	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		OrderServiceImpl = orderServiceImpl;
	}


	public String getDealCardId() {
		return dealCardId;
	}


	public void setDealCardId(String dealCardId) {
		this.dealCardId = dealCardId;
	}


	public String getDealChannel() {
		return dealChannel;
	}


	public void setDealChannel(String dealChannel) {
		this.dealChannel = dealChannel;
	}


	public OrderAll getOrderAll() {
		return orderAll;
	}


	public void setOrderAll(OrderAll orderAll) {
		this.orderAll = orderAll;
	}


	public AccountFee getAccountFee() {
		return accountFee;
	}


	public void setAccountFee(AccountFee accountFee) {
		this.accountFee = accountFee;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getOrderGenerationIp() {
		return orderGenerationIp;
	}
	public void setOrderGenerationIp(String orderGenerationIp) {
		this.orderGenerationIp = orderGenerationIp;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
}
