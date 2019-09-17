package com.pay.gateway.service;

import com.pay.gateway.entity.WithdrawalsOrder;
import com.pay.gateway.entity.WithdrawalsRecord;

public interface MerchantsService {

	/**
	 * <p>生成提现记录订单</p>
	 * @param wr
	 * @return
	 */
	boolean addWithdrawalsRecord(WithdrawalsRecord wr);

	/**
	 * <p>生成代付订单数据</p>
	 * @param order
	 * @return
	 */
	boolean addWithdrawalsOrder(WithdrawalsOrder order);

	/**
	 * <p>根据全局订单修改提现记录表数据未提现失败，原因为流水生成失败</p>
	 * @param orderId
	 * @param dpayStatusEr
	 * @return
	 */
	boolean updataWithdrawalsRecord(String orderId, Integer dpayStatusEr);

	/**
	 * <p>根据全局点歌单修改代付订单数据未代付失败，原因为流水生成失败</p>
	 * @param orderId
	 * @param wiDpayStatusEr
	 * @return
	 */
	boolean updataWithdrawalsOrder(String orderId, Integer wiDpayStatusEr);

	/**
	 * <p>根据全局订单查询代付订单数据</p>
	 * @param orderId
	 * @return
	 */
	WithdrawalsOrder findMerchantsOrderByOrderAllId(String orderId);

}
