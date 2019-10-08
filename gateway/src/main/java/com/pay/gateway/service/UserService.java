package com.pay.gateway.service;

import com.pay.gateway.entity.User;

public interface UserService {
	/**
	 * <p>根据账户查询用户信息</p>
	 * @param userId
	 * @return
	 */
	User findUserByuserId(String userId);

	/**
	 * <p>更新代理商金额</p>
	 * @param agent
	 * @return
	 */
	boolean updataUserById(User agent);
}
