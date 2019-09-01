package com.pay.gateway.service;

import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;

public interface OrderService {

	/**
	 * <p>根据外部商户号和外部订单号查询交易订单</p>
	 * @param appid
	 * @param orderid
	 * @return
	 */
	OrderAll findOrderByTradeId(String appid, String orderid);

	/**
	 * <p>增加交易订单</p>
	 * @param dealOrder
	 * @return
	 */
	Boolean addDealOrder(DealOrder dealOrder);

	/**
	 * <p>生成全局关联订单</p>
	 * @param orderAll
	 * @return
	 */
	Boolean addOrderAll(OrderAll orderAll);

	/**
	 * <p>根据全局订单号和订单金额生成交易订单</p>
	 * @param order
	 * @param amount
	 * @return
	 */
	boolean createOrder(String order, String amount);

}
