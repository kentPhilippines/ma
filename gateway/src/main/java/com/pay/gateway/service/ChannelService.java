package com.pay.gateway.service;

import com.pay.gateway.entity.ChannelFee;

public interface ChannelService {

	/**
	 * <p>通过通道表示查询通道</p>
	 * @param passcode
	 * @return
	 */
	ChannelFee findChanenlFee(String passcode);

	/**
	 * <p>根据渠道和产品查询渠道产品具体的信息</p>
	 * @param accountChannel
	 * @param channelProduct
	 * @return
	 */
	ChannelFee findChanenlFeeByChannelNo(String accountChannel, String channelProduct);


}
