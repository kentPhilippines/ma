package com.pay.gateway.service.impl;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.config.service.PayOrderService;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.AccountFeeExample;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.OrderAllExample;
import com.pay.gateway.entity.OrderAllExample.Criteria;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;
import com.pay.gateway.mapper.AccountFeeMapper;
import com.pay.gateway.mapper.AccountMapper;
import com.pay.gateway.mapper.DealOrderMapper;
import com.pay.gateway.mapper.OrderAllMapper;
import com.pay.gateway.service.OrderService;

import cn.hutool.core.collection.CollUtil;
@Service
public class OrderServiceImpl extends PayOrderService implements OrderService  {
	Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	OrderAllMapper orderAllDao;
	@Autowired
	DealOrderMapper dealOrderDao;
	@Autowired
	AccountFeeMapper accountFeeDao;
	@Autowired
	AccountMapper accountDao;
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
	@Override
	public ResultDeal deal(Deal deal, Account account, AccountFee accountFee, OrderAll orderAll) {
		return null;
	}
	@Override
	public boolean createOrder(String order, String amount) {
		log.info("=========【订单生成抽象实现类开始执行】============");
		OrderAllExample example = new OrderAllExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(order);
		List<OrderAll> selectByExample = orderAllDao.selectByExample(example);
		OrderAll orderAll = CollUtil.getFirst(selectByExample);//理论上这个值不可能为null
		AccountFeeExample exampleF = new AccountFeeExample();
		com.pay.gateway.entity.AccountFeeExample.Criteria criteriaF = exampleF.createCriteria();
		criteriaF.andIdEqualTo(Integer.valueOf(orderAll.getRetain2()));
		List<AccountFee> selectByExample2 = accountFeeDao.selectByExample(exampleF);
		AccountFee accountFee = CollUtil.getFirst(selectByExample2);//理论上这个值不可能为null
		this.amount = new BigDecimal(amount);
		this.appid = orderAll.getOrderAccount();
		this.tradeId = orderAll.getRetain1();//外部订单号
		this.orderType = orderAll.getOrderType();
		this.dealChannel = accountFee.getAccountChannel();//
		this.orderGenerationIp = orderAll.getOrderIp();
		this.orderAll = orderAll;
		this.accountFee = accountFee ;
		this.notfty = orderAll.getRetain3();
		if(dealOrder()) {
			log.info("===============【交易订单成生成功】==================");
			return true;
		}
		return false;
	}
}
