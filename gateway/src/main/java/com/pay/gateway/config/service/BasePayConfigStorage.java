package com.pay.gateway.config.service;


/**
 * <p>支付实体类抽象</p>
 * @author K
 *
 */
public abstract class BasePayConfigStorage implements PayConfigStorage {
	 /**
     * 异步回调地址
     */
    private String notifyUrl;
    /**
     * 同步回调地址，支付完成后展示的页面
     */
    private String returnUrl;
    /**
     * 默认为正式环境
     */
    private boolean isTest = true;
    /**
     * 支付平台公钥(签名校验使用)
     */
    private String keyPublic;
    /**
     * 应用私钥，rsa_private pkcs8格式 生成签名时使用
     */
    private String keyPrivate;
    
    @Override
    public boolean isTest() {
    	return isTest;
    }
    public void setTest(boolean test) {
    	isTest = test;
    }
    
    @Override
    public String getNotifyUrl() {
    	return notifyUrl;
    }
    @Override
    public String getKeyPrivate() {
    	return keyPrivate;
    }
    @Override
    public String getKeyPublic() {
    	return keyPublic;
    }
    @Override
    public String getReturnUrl() {
    	return returnUrl;
    }
    
}
