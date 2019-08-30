package com.pay.gateway.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.pay.gateway.entity.base.BaseEntity;
public class AccountFee extends BaseEntity{
    private String accountId;//账户id
    private String accountChannel;//渠道
    private String channelProduct;//产品
    private String accountFee;//费率
    private String accountCost;//成本费率
    private String withdrawal;//取款费率
    private String withdrawalCost;//取款成本费率
    private Integer feeStautus;//费率状态

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }
    public String getAccountChannel() {
        return accountChannel;
    }

    public void setAccountChannel(String accountChannel) {
        this.accountChannel = accountChannel == null ? null : accountChannel.trim();
    }

    public String getChannelProduct() {
        return channelProduct;
    }

    public void setChannelProduct(String channelProduct) {
        this.channelProduct = channelProduct == null ? null : channelProduct.trim();
    }

    public String getAccountFee() {
        return accountFee;
    }

    public void setAccountFee(String accountFee) {
        this.accountFee = accountFee == null ? null : accountFee.trim();
    }

    public String getAccountCost() {
        return accountCost;
    }

    public void setAccountCost(String accountCost) {
        this.accountCost = accountCost == null ? null : accountCost.trim();
    }

    public String getWithdrawal() {
        return withdrawal;
    }
    public void setWithdrawal(String withdrawal) {
        this.withdrawal = withdrawal == null ? null : withdrawal.trim();
    }
    public String getWithdrawalCost() {
        return withdrawalCost;
    }
    public void setWithdrawalCost(String withdrawalCost) {
        this.withdrawalCost = withdrawalCost == null ? null : withdrawalCost.trim();
    }
    public Integer getFeeStautus() {
        return feeStautus;
    }
    public void setFeeStautus(Integer feeStautus) {
        this.feeStautus = feeStautus;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}