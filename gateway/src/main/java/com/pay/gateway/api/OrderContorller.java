package com.pay.gateway.api;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pay.gateway.util.SendUtil;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/notify")
public class OrderContorller {
	private final String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAu0wb+QnOIwVPMj3hs1Q6pFuLLdQFdc9baTRMPw6X+x3Lhmrk16AGep6ggcvFKEAWyZmyg33gmgZwJMGoWj1utQIDAQABAkB9lv5W0p1X3FKLhPUX043y8bN0ymvS4HUSKVBLJBUC+4GUpH4ng/4NkA3hYoa91AJfK/kQ7PTuTNIbdzUzLkntAiEA/uQS8RMT41P/ZUQofiDDgUGRuFgL+vsOgR387QextfMCIQC8HL3wlkZfwvcVKDuQ5OEICpzc8Ci2ZfTEogPnrluqtwIhAL620CVo7NyPIO0YTmPxB9dSxEF2P6CO8I9TbMe9lg5ZAiEAhGV+UcySr2ebW6q7cdmFgJFnoiDtpqLPyW12biPLpLUCIDU0PmBhO3nomUgNdUwyQESFPBKh0T9Y0w3Dh1x8mb/F\r\n" ; 
	private final String publicKey ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALtMG/kJziMFTzI94bNUOqRbiy3UBXXPW2k0TD8Ol/sdy4Zq5NegBnqeoIHLxShAFsmZsoN94JoGcCTBqFo9brUCAwEAAQ==\r\n"; //new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
	Logger log = LoggerFactory.getLogger(OrderContorller.class);
	@Autowired
	OrderUtil orderUtil;
	@Autowired
	NotifyUtil notifyUtil;
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	SendUtil sendUtil;
	/**
	 * <p>单纯向下游发送现有订单的通知</p>
	 * @param OrderId		订单号
	 */
	@PostMapping("/notifyOrder")	
	@Transactional
	public JsonResult notifyOrder(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, String> decryptionParam = null;
		try {
			decryptionParam = sendUtil.decryptionParam(request);
		} catch (Exception e) {
			return JsonResult.buildFailResult("请求参数解密异常");
		}
		String orderId = decryptionParam.get("orderId");
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
	public JsonResult updataOrder(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, String> decryptionParam = null;
		try {
			decryptionParam = sendUtil.decryptionParam(request);
		} catch (Exception e) {
			return JsonResult.buildFailResult("请求参数解密异常");
		}
		String orderId = decryptionParam.get("orderId");
		log.info("|----收到后台向网关调用网关将订单置为成功的方法并向下游用户重新发送通知，订单号为："+orderId);
		if(StrUtil.isBlank(orderId)) {
			return JsonResult.buildFailResult("订单号为空");
		}
		DealOrder dealOrder = orderServiceImpl.findOrderByOrderId(orderId);
		if(ObjectUtil.isNull(dealOrder)) {
			return JsonResult.buildFailResult("服务器内未查询到有效订单");
		}
		boolean updataOrderStatus = orderUtil.updataOrderStatus(dealOrder.getAssociatedId(),Common.RUN_STATUS_2);
		log.info("|-----------接收到后台请求修改订单结果："+updataOrderStatus);
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
