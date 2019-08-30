package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.ChannelFee;
import com.pay.gateway.entity.ChannelFeeExample;
import com.pay.gateway.entity.ChannelFeeExample.Criteria;
import com.pay.gateway.mapper.ChannelFeeMapper;
import com.pay.gateway.service.ChannelService;

import cn.hutool.core.collection.CollUtil;
@Service
public class ChannelServiceImpl implements ChannelService{
	@Autowired
	ChannelFeeMapper channelFeeDao;
	@Override
	public ChannelFee findChanenlFee(String passcode) {
		return null;
	}
	@Override
	public ChannelFee findChanenlFeeByChannelNo(String channelNo, String channelProduct) {
		ChannelFeeExample example = new ChannelFeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andChannelNoEqualTo(channelNo);
		criteria.andPayTypeEqualTo(channelProduct);
		List<ChannelFee> selectByExample = channelFeeDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}

}
