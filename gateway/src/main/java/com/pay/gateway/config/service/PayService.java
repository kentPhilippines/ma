package com.pay.gateway.config.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.pay.gateway.config.entity.PayOrder;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;

public interface PayService {
    
	/**
	 * <p>支付交易</p>
	 * @param deal
	 * @param accountFee 
	 * @param account 
	 * @param orderAll 
	 * @return
	 */
	ResultDeal deal(Deal deal, Account account, AccountFee accountFee, OrderAll orderAll);
	/**
     * 页面转跳支付， 返回对应页面重定向信息
     * @param order 订单信息
     * @return 对应页面重定向信息
     */
    String toPay(PayOrder order);
    /**
     * 将请求参数或者请求流转化为 Map
     *
     * @param parameterMap 请求参数
     * @param is           请求流
     * @return 获得回调的请求参数
     */
    Map<String, Object> getParameter2Map(Map<String, String[]> parameterMap, InputStream is);
    /**
     * 获取输出二维码，用户返回给支付端,
     *
     * @param order 发起支付的订单信息
     * @return 返回图片信息，支付时需要的
     */
    BufferedImage genQrPay(PayOrder order);
    /**
     * 交易查询接口
     *
     * @param tradeNo    支付平台订单号
     * @param outTradeNo 商户单号
     * @return 返回查询回来的结果集，支付方原值返回
     */
    Map<String, Object> query(String tradeNo, String outTradeNo);

    /**
     * 返回创建的订单信息
     * @param order 支付订单
     * @return 订单信息
     * @see PayOrder 支付订单信息
     */
    Map<String, Object>  orderInfo(PayOrder order);
}
