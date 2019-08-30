package com.pay.gateway.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.pay.gateway.entity.base.BaseEntity;

public class ChannelFee  extends BaseEntity{
    private String channelNo;
    private String channelAccount;
    private String channelName;
    private String payType;
    private String fee;
    private String settle;
    private String routing;
    public String getChannelNo() {
        return channelNo;
    }
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }
    public String getChannelAccount() {
        return channelAccount;
    }
    public void setChannelAccount(String channelAccount) {
        this.channelAccount = channelAccount == null ? null : channelAccount.trim();
    }
    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }
    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
    }
    public String getSettle() {
        return settle;
    }
    public void setSettle(String settle) {
        this.settle = settle == null ? null : settle.trim();
    }
    public String getRouting() {
        return routing;
    }
    public void setRouting(String routing) {
        this.routing = routing == null ? null : routing.trim();
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}