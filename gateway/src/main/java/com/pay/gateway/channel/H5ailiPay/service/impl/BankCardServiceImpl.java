package com.pay.gateway.channel.H5ailiPay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.entity.BankCard;
import com.pay.gateway.entity.BankCardExample;
import com.pay.gateway.entity.BankCardExample.Criteria;
import com.pay.gateway.mapper.BankCardMapper;
@Service
public class BankCardServiceImpl implements BankCardService {
	@Autowired
	BankCardMapper bankCardDao;
	@Override
	public List<BankCard> findBankCardAll() {
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		List<BankCard> selectByExample = bankCardDao.selectByExample(example);
		return selectByExample;
	}
}
