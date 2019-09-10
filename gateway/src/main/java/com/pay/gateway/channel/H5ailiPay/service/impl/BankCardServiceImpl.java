package com.pay.gateway.channel.H5ailiPay.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.entity.BankCard;
import com.pay.gateway.entity.BankCardExample;
import com.pay.gateway.entity.BankCardExample.Criteria;
import com.pay.gateway.mapper.BankCardMapper;

import cn.hutool.core.collection.CollUtil;
@Service
public class BankCardServiceImpl implements BankCardService {
	@Autowired
	BankCardMapper bankCardDao;
	@Override
	public List<BankCard> findBankCardAll() {
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankTypeEqualTo(0);
		criteria.andStatusEqualTo(1);
		List<BankCard> selectByExample = bankCardDao.selectByExample(example);
		return selectByExample;
	}
	@Override
	public boolean updataAmountByBankCardId(BankCard bank) {
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankCardEqualTo(bank.getBankCard());
		List<BankCard> selectByExample = bankCardDao.selectByExample(example);
		BankCard first = null;
		if(CollUtil.isNotEmpty(selectByExample)) {
			first = CollUtil.getFirst(selectByExample);
			bank.setBankAmount(first.getBankAmount().add(bank.getBankAmount()));
		}		
		String retain1 = first.getRetain1();
		BigDecimal bankAmount = bank.getBankAmount();//儅纍計金額大於銀行卡交易範圍的時候  將銀行卡設置爲不可用
		BigDecimal limitAmount = new BigDecimal(retain1);//銀行卡限制交易金額
		if(limitAmount.compareTo(bankAmount) == -1){//交易纍計大於交易額度的時候
			bank.setStatus(0);
		}
		bank.setCreateTime(null);
		int updateByExample = bankCardDao.updateByExample(bank, example);
		return updateByExample > 1 && updateByExample < 2;
	}
}
