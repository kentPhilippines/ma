package com.pay.gateway.channel.H5ailiPay.service;

import java.util.List;

import com.pay.gateway.entity.BankCard;

public interface BankCardService {
	List<BankCard> findBankCardAll();
	/**
	 * <p>根據銀行卡號修改銀行卡數據</p>
	 * @param bank
	 * @return
	 */
	boolean updataAmountByBankCardId(BankCard bank);
}
