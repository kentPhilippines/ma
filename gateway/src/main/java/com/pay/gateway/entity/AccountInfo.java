package com.pay.gateway.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AccountInfo {
    private Integer id;

    private String accountId;

    private String agentAccount;

    private Integer isAgant;

    private String password;

    private Date createTime;

    private Date submitTime;

    private String submitSystem;

    private Integer status;

    private String appKey;

    private String appDesKey;

    private String accountIp;

    private String havaInterface;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAgentAccount() {
        return agentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount == null ? null : agentAccount.trim();
    }

    public Integer getIsAgant() {
        return isAgant;
    }

    public void setIsAgant(Integer isAgant) {
        this.isAgant = isAgant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitSystem() {
        return submitSystem;
    }

    public void setSubmitSystem(String submitSystem) {
        this.submitSystem = submitSystem == null ? null : submitSystem.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppDesKey() {
        return appDesKey;
    }

    public void setAppDesKey(String appDesKey) {
        this.appDesKey = appDesKey == null ? null : appDesKey.trim();
    }

    public String getAccountIp() {
        return accountIp;
    }

    public void setAccountIp(String accountIp) {
        this.accountIp = accountIp == null ? null : accountIp.trim();
    }

    public String getHavaInterface() {
        return havaInterface;
    }

    public void setHavaInterface(String havaInterface) {
        this.havaInterface = havaInterface == null ? null : havaInterface.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}