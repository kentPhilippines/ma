package com.pay.gateway.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pay.gateway.entity.ExceptionOrderEntity;
import com.pay.gateway.mapper.ExceptionOrderEntityMapper;
import com.pay.gateway.service.ExceptionOrderService;
@Service
public class ExceptionOrderServiceImpl implements ExceptionOrderService{
	@Autowired
	ExceptionOrderEntityMapper ExceptionOrderEntityDao;
	@Override
	public boolean addExceptionOrder(ExceptionOrderEntity exceopt) {
		int insertSelective = ExceptionOrderEntityDao.insertSelective(exceopt);
		return insertSelective > 0 && insertSelective < 2;
	}
}
