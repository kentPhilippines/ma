package com.pay.gateway.config.service;

public interface PayConfigStorage {
	 /**
     * 服务端异步回调Url
     *  @return 异步回调Url
     */
     String getNotifyUrl();
    /**
     * 服务端同步回调Url
     *  @return 同步回调Url
     */
     String getReturnUrl();
     /**
      * 是否为测试环境， true测试环境
      * @return true测试环境
      */
     boolean isTest();
     /**
      * 支付平台公钥(签名校验使用)
      * @return 公钥
      */
      String getKeyPublic();

     /**
      *  应用私钥(生成签名时使用)
      * @return 私钥
      */
      String getKeyPrivate();
}
