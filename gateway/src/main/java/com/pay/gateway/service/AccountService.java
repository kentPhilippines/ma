package com.pay.gateway.service;

import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountInfo;

public interface AccountService {

	/**
	 * <p>根据用户id用户信息</p>
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

	/**
	 * <p>交易完成之後修改賬戶的數據</p>
	 * @param account
	 * @return
	 */
	boolean updataAccountByAcoountId(Account account);

	
	/**
	 * <p>修改賬戶凍結金額為可取現金額</p>
	 */
	void updataAccountAmount();

}
