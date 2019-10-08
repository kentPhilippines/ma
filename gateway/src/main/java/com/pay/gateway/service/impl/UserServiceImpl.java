package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.User;
import com.pay.gateway.entity.UserExample;
import com.pay.gateway.entity.UserExample.Criteria;
import com.pay.gateway.mapper.UserMapper;
import com.pay.gateway.service.UserService;

import cn.hutool.core.collection.CollUtil;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userDao;
	@Override
	public User findUserByuserId(String userId) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<User> selectByExample = userDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample)) {
			User first = CollUtil.getFirst(selectByExample);
			return first;
		}
		return null;
	}
	@Override
	public boolean updataUserById(User agent) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(agent.getId());
		int updateByExampleSelective = userDao.updateByExampleSelective(agent, example);
		return updateByExampleSelective > 0 && updateByExampleSelective < 2;
	}
}
