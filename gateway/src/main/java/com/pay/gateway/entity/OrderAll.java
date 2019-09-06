package com.pay.gateway.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.pay.gateway.entity.base.BaseEntity;

public class OrderAll extends BaseEntity{
    private String orderId;//全局訂單
    private Integer orderType;//订单类型:1交易,5代付
    private String orderAccount;//订单关联商户账号
    private String orderAmount;//订单金额(原始金额)
    private String orderIp;//订单生成IP(源头ip)
    private String retain1;//银行卡交易外部订单号
    private String retain2;//使用费率编号
    private String retain3;//订单回调地址
    private String retain4;//使用費率數據id
    private String retain5;
    private String retain6;
    private String retain7;
    private String retain8;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
    public Integer getOrderType() {
        return orderType;
    }
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    public String getOrderAccount() {
        return orderAccount;
    }
    public void setOrderAccount(String orderAccount) {
        this.orderAccount = orderAccount == null ? null : orderAccount.trim();
    }
    public String getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount == null ? null : orderAmount.trim();
    }
    public String getOrderIp() {
        return orderIp;
    }
    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp == null ? null : orderIp.trim();
    }
    public String getRetain1() {
        return retain1;
    }
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }
    public String getRetain2() {
        return retain2;
    }
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }
    public String getRetain3() {
        return retain3;
    }
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    public String getRetain4() {
        return retain4;
    }

    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    public String getRetain5() {
        return retain5;
    }
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
    public String getRetain6() {
        return retain6;
    }
    public void setRetain6(String retain6) {
        this.retain6 = retain6 == null ? null : retain6.trim();
    }
    public String getRetain7() {
        return retain7;
    }
    public void setRetain7(String retain7) {
        this.retain7 = retain7 == null ? null : retain7.trim();
    }
    public String getRetain8() {
        return retain8;
    }

    public void setRetain8(String retain8) {
        this.retain8 = retain8 == null ? null : retain8.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}