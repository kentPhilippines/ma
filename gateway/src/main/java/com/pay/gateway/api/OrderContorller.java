package com.pay.gateway.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.exception.OtherErrors;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.JsonResult;
import com.pay.gateway.util.NotifyUtil;
import com.pay.gateway.util.OrderUtil;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/notify")
public class OrderContorller {
	Logger log = LoggerFactory.getLogger(OrderContorller.class);
	@Autowired
	OrderUtil orderUtil;
	@Autowired
	NotifyUtil notifyUtil;
	@Autowired
	OrderService orderServiceImpl;
	/**
	 * <p>单纯向下游发送现有订单的通知</p>
	 * @param OrderId		订单号
	 */
	@PostMapping("/notifyOrder")	
	@Transactional
	public JsonResult notifyOrder(@Param("orderId")String orderId) {
		log.info("|----收到后台向网关调用网关向用户发送通知的方法，订单号为："+orderId);
		if(StrUtil.isBlank(orderId)) {
			return JsonResult.buildFailResult("订单号为空");
		}
		DealOrder dealOrder = orderServiceImpl.findOrderByOrderId(orderId);
		if(ObjectUtil.isNull(dealOrder)) {
			return JsonResult.buildFailResult("服务器内未查询到有效订单");
		}
		Integer orderStatus = dealOrder.getOrderStatus();
		if(Common.ORDERDEASTATUS_SU.equals(orderStatus)) {//成功的时候
			notifyUtil.sendMsg(dealOrder.getAssociatedId(), true);
			return JsonResult.buildSuccessMessage("订单通知补发成功");
		}
		notifyUtil.sendMsg(dealOrder.getAssociatedId(), false);
		return JsonResult.buildSuccessMessage("订单通知补发成功");
	}
	/**
	 * <p>修改订单为成功,并生成流水</p>
	 * @param orderId
	 * @return
	 */
	@PostMapping("/updataOrder")	
	@ResponseBody
	@Transactional
	public JsonResult updataOrder(@Param("orderId")String orderId) {
		log.info("|----收到后台向网关调用网关将订单置为成功的方法并向下游用户重新发送通知，订单号为："+orderId);
		if(StrUtil.isBlank(orderId)) {
			return JsonResult.buildFailResult("订单号为空");
		}
		DealOrder dealOrder = orderServiceImpl.findOrderByOrderId(orderId);
		if(ObjectUtil.isNull(dealOrder)) {
			return JsonResult.buildFailResult("服务器内未查询到有效订单");
		}
		boolean updataOrderStatus = orderUtil.updataOrderStatus(dealOrder.getAssociatedId());
		notifyUtil.sendMsg(dealOrder.getAssociatedId(), updataOrderStatus);
		log.info("|-----------接收到后台请求修改订单结果："+updataOrderStatus);
		if(updataOrderStatus) {
			return JsonResult.buildSuccessMessage("订单修改成功,并向用户发送通知");
		}
		if(!updataOrderStatus)//回滚所有数据
			 throw new OtherErrors("交易回调发生异常");
		return JsonResult.buildFailResult("修改失败");
	}
	
	
	
	
	
	
	

}
