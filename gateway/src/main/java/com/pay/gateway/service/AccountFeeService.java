package com.pay.gateway.service;

import java.util.List;

import com.pay.gateway.entity.AccountFee;

public interface AccountFeeService {

	/**
	 * <p>根据用户id查询用户详细费率信息</p>
	 * @param appid
	 * @param feeStatus1 
	 * @return
	 */
	List<AccountFee> findAccountFeeBy(String appid,String product, Integer feeStatus1);

	/**
	 * <p>通过账户费率信息查找唯一费率</p>
	 * @param appid
	 * @param channelNo
	 * @param payType
	 * @param feeStatus1
	 * @return
	 */
	List<AccountFee> findAccountFeeBy(String appid, String channelNo, String payType, Integer feeStatus1);

	/**
	 * <p>根据费率数据id查找费率数据</p>
	 * @param valueOf
	 * @return
	 */
	AccountFee findAccountFeeByFeeId(Integer valueOf);

}
