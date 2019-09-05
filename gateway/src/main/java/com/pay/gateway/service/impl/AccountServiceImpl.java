package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountExample;
import com.pay.gateway.entity.AccountExample.Criteria;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.entity.AccountInfoExample;
import com.pay.gateway.mapper.AccountInfoMapper;
import com.pay.gateway.mapper.AccountMapper;
import com.pay.gateway.service.AccountService;

import cn.hutool.core.collection.CollUtil;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountMapper accountDao;
	@Autowired
	AccountInfoMapper accountInfoDao;
	@Override
	public Account findAccountByAppId(String appid) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		List<Account> selectByExample = accountDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
	@Override
	public AccountInfo findAccountInfoByAppId(String appid) {
		AccountInfoExample example = new AccountInfoExample();
		com.pay.gateway.entity.AccountInfoExample.Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(appid);
		List<AccountInfo> selectByExample = accountInfoDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
	@Override
	public boolean updataAccountByAcoountId(Account account) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(account.getAccountId());
		int updateByExample = accountDao.updateByExample(account, example);
		return updateByExample > 0 && updateByExample < 2;
	}

}
