package com.pay.gateway.channel.xiaoEHuaFei.entity;

public class XiaoeHuaFeiDate {
	private String qrcode;
	private String url;
	private String order_no;
/*	qrcode	string	支付的链接，用于二次生成支付二维码
	url	string	支付的跳转链接，直接跳转支付
	order_no	int	系统订单号
*/
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	
	
}
