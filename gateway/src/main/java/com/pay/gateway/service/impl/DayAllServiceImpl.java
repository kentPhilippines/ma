package com.pay.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.mapper.DayAllMapper;
import com.pay.gateway.service.DayAllService;
@Service
public class DayAllServiceImpl implements DayAllService {
	@Autowired
	DayAllMapper dayAllDao;
}
