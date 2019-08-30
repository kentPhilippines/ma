package com.pay.gateway.service;

import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountInfo;

public interface AccountService {

	/**
	 * <p>根据用户状态查询用户信息</p>
	 * @param appid
	 * @return
	 */
	Account findAccountByAppId(String appid);

	/**
	 * <p>根据用户信息查询用户详细信息</p>
	 * @param appid
	 * @return
	 */
	AccountInfo findAccountInfoByAppId(String appid);

}
