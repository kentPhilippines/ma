package com.pay.gateway.entity;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.pay.gateway.entity.base.BaseEntity;

public class Account extends BaseEntity{
	/**
	 *	<p>賬戶id</p>
	 */
    private String accountId; 
    /**
	 *	<p>賬戶昵稱</p>
	 */
    private String accountName;
    /**
	 *	<p>商户是否可用:0可用1停用</p>
	 */
    private Integer accountType;
    /**
	 *	<p>商户账户可提现余额</p>
	 */
    private BigDecimal cashBalance;
    /**
	 *	<p>商户冻结资金</p>
	 */
    private BigDecimal freezeBalance;
    /**
	 *	<p>商户账户余额=冻结金额+可提现余额</p>
	 */
    private BigDecimal accountBalance;
    /**
	 *	<p>商户日交易(充值)额度最高</p>
	 */
    private BigDecimal dayDealAmountMax;
    /**
	 *	<p>商户日交易(充值)额度最低</p>
	 */
    private BigDecimal dayDealAmountMin;
    /**
	 *	<p>商户累计交易额度</p>
	 */
    private BigDecimal sumDealAmount;
    /**
	 *	<p>商户当天交易额度</p>
	 */
    private BigDecimal sumDealToDayAmount;
    /**
	 *	<p>凍結T1賬戶</p>
	 */
    private BigDecimal freezeT1;
    /**
	 *	<p>凍結D1賬戶</p>
	 */
    private BigDecimal freezeD1;
    
    
    
    

    public BigDecimal getFreezeT1() {
		return freezeT1;
	}
	public void setFreezeT1(BigDecimal freezeT1) {
		this.freezeT1 = freezeT1;
	}
	public BigDecimal getFreezeD1() {
		return freezeD1;
	}
	public void setFreezeD1(BigDecimal freezeD1) {
		this.freezeD1 = freezeD1;
	}
	public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }
    public Integer getAccountType() {
        return accountType;
    }
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
    public BigDecimal getCashBalance() {
        return cashBalance;
    }
    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
    public BigDecimal getDayDealAmountMax() {
        return dayDealAmountMax;
    }
    public void setDayDealAmountMax(BigDecimal dayDealAmountMax) {
        this.dayDealAmountMax = dayDealAmountMax;
    }
    public BigDecimal getDayDealAmountMin() {
        return dayDealAmountMin;
    }
    public void setDayDealAmountMin(BigDecimal dayDealAmountMin) {
        this.dayDealAmountMin = dayDealAmountMin;
    }
    public BigDecimal getSumDealAmount() {
        return sumDealAmount;
    }
    public void setSumDealAmount(BigDecimal sumDealAmount) {
        this.sumDealAmount = sumDealAmount;
    }
    public BigDecimal getSumDealToDayAmount() {
        return sumDealToDayAmount;
    }
    public void setSumDealToDayAmount(BigDecimal sumDealToDayAmount) {
        this.sumDealToDayAmount = sumDealToDayAmount;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}