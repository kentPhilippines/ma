package com.pay.gateway.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.pay.gateway.entity.base.BaseEntity;

public class AccountFee extends BaseEntity{
	/**
	 * <p>取款费率成本</p>
	 */
    private String withdrawalCost;
    /**
	 * <p>商户id</p>
	 */
    private String accountId;
    /**
	 * <p>商户对应渠道(这个字段也可填写代理商)</p>
	 */
    private String accountChannel;
    /**
	 * <p>渠道产品类型</p>
	 */
    private String channelProduct;
    /**
	 * <p>商户费率</p>
	 */
    private String accountFee;
    /**
	 * <p>商户成本(只统计上游费率)</p>
	 */
    private String accountCost;
    /**
	 * <p>取款费率</p>
	 */
    private String withdrawal;
    /**
	 * <p>费率状态；1启用2停用3自动切换</p>
	 */
    private Integer feeStautus;
    /**
	 * <p>凍結百分比</p>
	 */
    private String accountSette;
    /**
	 * <p>結算時間 時分秒</p>
	 */
    private Date settleTime;
    /**
	 * <p>D1賬戶/T1賬戶</p>
	 */
    private String settlementType;
    private String retain1;
    private String retain2;
    private String retain3;
    private String retain4;
    private String retain5;
    private String retain6;
    private String retain7;
    private String retain8;
    private String retain9;

    public String getWithdrawalCost() {
        return withdrawalCost;
    }
    public void setWithdrawalCost(String withdrawalCost) {
        this.withdrawalCost = withdrawalCost == null ? null : withdrawalCost.trim();
    }
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
    public Integer getFeeStautus() {
        return feeStautus;
    }
    public void setFeeStautus(Integer feeStautus) {
        this.feeStautus = feeStautus;
    }
    public String getAccountSette() {
        return accountSette;
    }
    public void setAccountSette(String accountSette) {
        this.accountSette = accountSette == null ? null : accountSette.trim();
    }
    public Date getSettleTime() {
        return settleTime;
    }
    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }
    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
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
    public String getRetain9() {
        return retain9;
    }
    public void setRetain9(String retain9) {
        this.retain9 = retain9 == null ? null : retain9.trim();
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}