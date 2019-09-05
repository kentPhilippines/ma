package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.AccountFeeExample;
import com.pay.gateway.entity.AccountFeeExample.Criteria;
import com.pay.gateway.mapper.AccountFeeMapper;
import com.pay.gateway.service.AccountFeeService;

import cn.hutool.core.collection.CollUtil;
@Service
public class AccountFeeServiceImpl implements AccountFeeService{
	@Autowired
	AccountFeeMapper accountFeeDao;
	@Override
	public List<AccountFee> findAccountFeeBy(String appid, Integer feeStatus1) {
		AccountFeeExample example = new AccountFeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		criteria.andFeeStautusEqualTo(feeStatus1);
		List<AccountFee> selectByExample = accountFeeDao.selectByExample(example);
		return selectByExample;
	}
	@Override
	public List<AccountFee> findAccountFeeBy(String appid, String channelNo, String payType, Integer feeStatus1) {
		AccountFeeExample example = new AccountFeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		criteria.andFeeStautusEqualTo(feeStatus1);
		criteria.andAccountChannelEqualTo(channelNo);
		criteria.andChannelProductEqualTo(payType);
		List<AccountFee> selectByExample = accountFeeDao.selectByExample(example);
		return selectByExample;
	}
	@Override
	public AccountFee findAccountFeeByFeeId(Integer valueOf) {
		AccountFeeExample example = new AccountFeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(valueOf);
		List<AccountFee> selectByExample = accountFeeDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
}
