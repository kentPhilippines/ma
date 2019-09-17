package com.pay.gateway.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.WithdrawalsOrder;
import com.pay.gateway.entity.WithdrawalsOrderExample;
import com.pay.gateway.entity.WithdrawalsRecord;
import com.pay.gateway.entity.WithdrawalsRecordExample;
import com.pay.gateway.entity.WithdrawalsRecordExample.Criteria;
import com.pay.gateway.mapper.WithdrawalsOrderMapper;
import com.pay.gateway.mapper.WithdrawalsRecordMapper;
import com.pay.gateway.service.MerchantsService;

import cn.hutool.core.collection.CollUtil;
@Service
public class MerchantsServiceImpl implements MerchantsService{
	Logger log = LoggerFactory.getLogger(MerchantsServiceImpl.class);
	@Autowired
	WithdrawalsRecordMapper WithdrawalsRecordDao;
	@Autowired
	WithdrawalsOrderMapper  WithdrawalsOrderDao;
	
	@Override
	public boolean addWithdrawalsRecord(WithdrawalsRecord wr) {
		int insertSelective = WithdrawalsRecordDao.insertSelective(wr);
		return insertSelective > 0 && insertSelective <2;
	}

	@Override
	public boolean addWithdrawalsOrder(WithdrawalsOrder order) {
		int insertSelective = WithdrawalsOrderDao.insertSelective(order);
		return insertSelective > 0 && insertSelective < 2;
	}

	@Override
	public boolean updataWithdrawalsRecord(String orderId, Integer dpayStatusEr) {
		WithdrawalsRecordExample example = new WithdrawalsRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		WithdrawalsRecord record = new WithdrawalsRecord();
		record.setMerchantsStatus(dpayStatusEr);
		int updateByExampleSelective = WithdrawalsRecordDao.updateByExampleSelective(record, example);
		return updateByExampleSelective > 0 && updateByExampleSelective <2;
	}

	@Override
	public boolean updataWithdrawalsOrder(String orderId, Integer wiDpayStatusEr) {
		WithdrawalsOrderExample example = new WithdrawalsOrderExample();
		com.pay.gateway.entity.WithdrawalsOrderExample.Criteria criteria = example.createCriteria();
		WithdrawalsOrder record = new WithdrawalsOrder();
		record.setOrderStatus(wiDpayStatusEr);
		int updateByExampleSelective = WithdrawalsOrderDao.updateByExampleSelective(record, example);
		return updateByExampleSelective > 0 && updateByExampleSelective < 2;
	}

	@Override
	public WithdrawalsOrder findMerchantsOrderByOrderAllId(String orderId) {
		WithdrawalsOrderExample example = new WithdrawalsOrderExample();
		com.pay.gateway.entity.WithdrawalsOrderExample.Criteria criteria = example.createCriteria();
		criteria.andAssociatedIdEqualTo(orderId);
		List<WithdrawalsOrder> selectByExample = WithdrawalsOrderDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample)) {
			return CollUtil.getFirst(selectByExample);
		}
		return null;
	}
}
