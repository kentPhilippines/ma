package com.pay.gateway.config.service;

/**
 * <p>支付渠道抽象类</p>
 * @author K
 * @param <PC>		渠道实体
 */
public abstract class ApiService<PC extends PayConfigStorage> implements PayService{
	/**
     * 异步回调地址
     */
    private String notifyUrl;
    /**
     * 同步回调地址，支付完成后展示的页面
     */
    private String returnUrl;
}
