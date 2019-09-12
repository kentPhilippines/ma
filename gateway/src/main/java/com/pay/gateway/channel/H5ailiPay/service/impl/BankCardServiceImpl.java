package com.pay.gateway.channel.H5ailiPay.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.BankCard;
import com.pay.gateway.entity.BankCardExample;
import com.pay.gateway.entity.BankCardExample.Criteria;
import com.pay.gateway.entity.BankCardRun;
import com.pay.gateway.mapper.BankCardMapper;
import com.pay.gateway.mapper.BankCardRunMapper;
import com.pay.gateway.util.OrderUtil;

import cn.hutool.core.collection.CollUtil;
@Service
public class BankCardServiceImpl implements BankCardService {
	Logger log = LoggerFactory.getLogger(BankCardServiceImpl.class);
	@Autowired
	BankCardMapper bankCardDao;
	@Autowired
	BankCardRunMapper bankCardRunDao;
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
		log.info("|----【进入银行卡核心处理类，当前位置为修改银行卡记录数据，当前修改的银行卡为："+bank.getBankCard()+"】");
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankCardEqualTo(bank.getBankCard());
		List<BankCard> selectByExample = bankCardDao.selectByExample(example);
		BankCard first = null;
		if(CollUtil.isNotEmpty(selectByExample)) {
			first = CollUtil.getFirst(selectByExample);
			log.info("|----【当前银行卡的交易金额为："+bank.getBankAmount()+"】");
			bank.setBankAmount(first.getBankAmount().add(bank.getBankAmount()));
		}		
		String retain1 = first.getRetain1();
		log.info("|----【当前银行卡的限制交易金额为："+retain1+"】");
		BigDecimal bankAmount = bank.getBankAmount();//儅纍計金額大於銀行卡交易範圍的時候  將銀行卡設置爲不可用
		BigDecimal limitAmount = new BigDecimal(retain1);//銀行卡限制交易金額
		log.info("|----【当前银行卡的同批次累计交易金额为："+bankAmount+"】");
		if(limitAmount.compareTo(bankAmount) == -1){//交易纍計大於交易額度的時候
			bank.setStatus(0);
		}
		bank.setCreateTime(null);
		int updateByExample = bankCardDao.updateByExampleSelective(bank, example);
		return updateByExample > 0 && updateByExample < 2;
	}
	@Override
	public boolean addBankRun(final BankCard bank,final BigDecimal actualAmount,final String accountId,final String orderId) {
		BigDecimal bankAmount = bank.getBankAmount();//银行交易金额 
		String bankCard =  bank.getBankCard();//入款卡号
		BigDecimal dealAmount = bankAmount.subtract(actualAmount);//自有账户分润金额
		BankCardRun entity = new BankCardRun();
		entity.setWithdrawAccount(accountId);
		entity.setWithdrawAmount(bankAmount);
		entity.setWithdrawBankCard(accountId);
		entity.setDealAccount("SYS");
		entity.setDealBankCard(bankCard);
		entity.setDealAmount(dealAmount);
		entity.setRunType(Common.BANKCARD_RUN_BENEFIT);
		entity.setRetain1(orderId);
		int insertSelective = bankCardRunDao.insertSelective(entity);//添加自有商户分润银行卡流水
		boolean flag = insertSelective > 0 && insertSelective < 2;
		entity.setDealAccount(accountId);
		entity.setDealAmount(actualAmount);
		entity.setDealBankCard(bankCard);
		entity.setRunType(Common.BANKCARD_RUN_DEAL);
		int insertSelective2 = bankCardRunDao.insertSelective(entity);//添加下游商户银行卡交易流水
		boolean flag1 = insertSelective2 > 0 && insertSelective2 < 2;
		if(flag && flag1) {
			return true ;
		}
		return false;
	}
	@Override
	public BankCard findBankCardByBankCardId(String dealCardId) {
		BankCardExample example = new BankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andBankCardEqualTo(dealCardId);
		List<BankCard> selectByExample = bankCardDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample)) 
			return CollUtil.getFirst(selectByExample);
		return null;
	}
}
