package com.pay.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.OrderAllExample;
import com.pay.gateway.entity.OrderAllExample.Criteria;
import com.pay.gateway.mapper.DealOrderMapper;
import com.pay.gateway.mapper.OrderAllMapper;
import com.pay.gateway.service.OrderService;

import cn.hutool.core.collection.CollUtil;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderAllMapper orderAllDao;
	@Autowired
	DealOrderMapper dealOrderDao;
	@Override
	public OrderAll findOrderByTradeId(String appid, String orderid) {
		OrderAllExample example = new OrderAllExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderAccountEqualTo(appid);
		criteria.andOrderIdEqualTo(orderid);
		List<OrderAll> selectByExample = orderAllDao.selectByExample(example);
		if(CollUtil.isNotEmpty(selectByExample))
			return CollUtil.getFirst(selectByExample);
		return null;
	}
	@Override
	public Boolean addOrderAll(OrderAll orderAll) {
		int insertSelective = orderAllDao.insertSelective(orderAll);
		return insertSelective > 0 && insertSelective < 2;
	}
	@Override
	public Boolean addDealOrder(DealOrder dealOrder) {
		int insertSelective = dealOrderDao.insertSelective(dealOrder);
		return insertSelective > 0 && insertSelective < 2;
	}
}
