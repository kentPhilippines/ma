package com.pay.gateway.channel.H5ailiPay.service;

import java.math.BigDecimal;
import java.util.List;

import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.BankCard;
import com.pay.gateway.entity.BankCardRun;

public interface BankCardService {
	List<BankCard> findBankCardAll();
	/**
	 * <p>根據銀行卡號修改銀行卡數據</p>
	 * @param bank
	 * @return
	 */
	boolean updataAmountByBankCardId(BankCard bank);
	/**
	 * <p>生成银行卡流水</p>	
	 * @param bank			该数据 只包含  入款金额和 银行卡号
	 * @param actualAmount	商户实际到账金额
	 * @param accountId		商户id
	 * @return
	 */
	boolean addBankRun(BankCard bank, BigDecimal actualAmount, String accountId,String orderId);
	/**
	 * <p>根据银行卡号查询银行卡详细信息</p>
	 * @param dealCardId
	 * @return
	 */
	BankCard findBankCardByBankCardId(String dealCardId);
}
