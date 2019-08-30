package com.pay.gateway.entity.dealEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p>交易实体类</p>
 * @author K
 *
 */
public class Deal {
	/**
	 * <p>商户号</p>
	 */
	private String appid; 
	/**
	 * <p>订单号(唯一)</p>
	 */
	private String orderid;
	/**
	 * <p>时间</p>
	 * <p>格式 :（YYYY-MM-DD H:m:s）：例如：2018-10-11 10:15:15</p>
	 */
	private String applydate;
	/**
	 * <p>异步通知地址</p>
	 */
	private String notifyurl;
	/**
	 * <p>金额</p>
	 * <p>以分为单位,例如:1000</p>
	 */
	private String amount;
	/**
	 * <p>签名</p>
	 */
	private String rsasign;
	/**
	 * <p>通道标识</p>
	 * <p>这里我们用它来确定分类 如  支付宝  云闪付  等   ： 10056</p>
	 */
	private String passcode;
	/**
	 * <p>支付成功返回地址。如果为空，支付成功之后返回提交页面</p>
	 */
	private String callbackurl;
	/**
	 * <p>备注信息</p>
	 */
	private String attach;
	/**
	 * <p>交易IP</p>
	 */
	private String ip;
	
	/**
	 * <p>关联订单</p>
	 */
	private String orderNo;
	
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getNotifyurl() {
		return notifyurl;
	}
	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRsasign() {
		return rsasign;
	}
	public void setRsasign(String rsasign) {
		this.rsasign = rsasign;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getCallbackurl() {
		return callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	 @Override
	    public String toString() {
	        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	    }
	
	
	
	
	
	
	
	
	

}
