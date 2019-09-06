package com.pay.gateway.service.impl;

import javax.annotation.Resource;

import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.RunningOrder;
import com.pay.gateway.entity.RunningOrderExample;
import com.pay.gateway.mapper.RunningOrderMapper;
import com.pay.gateway.service.RunningOrderService;
import com.pay.gateway.util.DealNumber;

import cn.hutool.core.util.StrUtil;
@Service
public class RunningOrderServiceImpl implements RunningOrderService {
	@Autowired
	RunningOrderMapper runningOrderDao;
	@Override
	public boolean createDealRun(DealOrder dealOrder) {
		RunningOrder runBean  = new RunningOrder();
		runBean.setOrderRunId(DealNumber.GetRunOrder());
		runBean.setOrderId(dealOrder.getOrderId());
		runBean.setRunStatus(Common.RUN_STATUS_1);
		runBean.setRunType(Common.RUN_TYPE_DEAL);
		runBean.setOrderAccount(dealOrder.getOrderAccount());
		runBean.setRunOrderAmount(dealOrder.getActualAmount().toString());
		runBean.setOrderGenerationIp(dealOrder.getOrderGenerationIp());
		runBean.setCardRunD(dealOrder.getOrderAccount());
		runBean.setCardRunW("SYS");//系統賬戶簡稱
		runBean.setCardNameRunW(StrUtil.isNotBlank(dealOrder.getDealCardId())?dealOrder.getDealCardId():"");
		int insertSelective = runningOrderDao.insertSelective(runBean);
		return insertSelective > 0 && insertSelective < 2;
	}
	@Override
	public boolean createDealRunFee(DealOrder dealOrder) {
		RunningOrder runBean  = new RunningOrder();
		runBean.setOrderRunId(DealNumber.GetRunOrder());
		runBean.setOrderId(dealOrder.getOrderId());
		runBean.setRunStatus(Common.RUN_STATUS_1);
		runBean.setRunType(Common.RUN_DEAL_FEE);
		runBean.setOrderAccount(dealOrder.getOrderAccount());
		runBean.setRunOrderAmount(dealOrder.getDealFee().toString());
		runBean.setOrderGenerationIp(dealOrder.getOrderGenerationIp());
		runBean.setCardRunD(dealOrder.getOrderAccount());
		runBean.setCardRunW("SYS");//系統賬戶簡稱
		runBean.setCardNameRunW(StrUtil.isNotBlank(dealOrder.getDealCardId())?dealOrder.getDealCardId():"");
		int insertSelective = runningOrderDao.insertSelective(runBean);
		return insertSelective > 0 && insertSelective < 2;
	}

}
