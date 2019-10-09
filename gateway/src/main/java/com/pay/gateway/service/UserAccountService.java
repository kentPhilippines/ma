package com.pay.gateway.service;

import com.pay.gateway.entity.User;
import com.pay.gateway.entity.UserAccount;

public interface UserAccountService {

	/**
	 * <p>通过商户号查询账户号</p>
	 * @param orderAccount
	 * @return
	 */
	UserAccount findUserByAccount(String orderAccount);

}
