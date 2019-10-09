package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.User;
import com.pay.gateway.entity.UserAccount;
import com.pay.gateway.entity.UserAccountExample;
import com.pay.gateway.entity.UserAccountExample.Criteria;
import com.pay.gateway.mapper.UserAccountMapper;
import com.pay.gateway.service.UserAccountService;

import cn.hutool.core.collection.CollUtil;
@Service
public class UserAccountServiceimpl  implements UserAccountService{

	@Autowired
	UserAccountMapper userAccountDao;
	
	@Override
	public UserAccount findUserByAccount(String orderAccount) {
		UserAccountExample example = new UserAccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(orderAccount);
		List<UserAccount> selectByExample = userAccountDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample)) {
			return	CollUtil.getFirst(selectByExample);
		}
		return null;
	}
}
