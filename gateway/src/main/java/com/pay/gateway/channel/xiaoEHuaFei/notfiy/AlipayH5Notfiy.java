package com.pay.gateway.channel.xiaoEHuaFei.notfiy;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pay.gateway.channel.pinDuoDuo.service.PinDuoDuoService;
import com.pay.gateway.channel.xiaoEHuaFei.util.xiaoEHuaFeiUtil;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.NotifyUtil;
import com.pay.gateway.util.OrderUtil;
import com.pay.gateway.util.SettingFile;

import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping("/xiaoEHuaFei")
public class AlipayH5Notfiy {
	Logger log = LoggerFactory.getLogger(PinDuoDuoService.class);
	@Autowired
	OrderService orderServiceImpl;
	@Resource
	OrderUtil orderUtil;
	@Resource
	NotifyUtil notifyUtil;
	@Autowired
	SettingFile settingFile;
	@RequestMapping("/notfiy")
	@Transactional
	public void notfiy(HttpServletRequest request ,HttpServletResponse response) throws Exception {
		log.info("【进入小额话费回调处理】");
		/**
		 *
		 *	memberid		商户号		是	平台分配的商户号
			orderid			订单号		是	商户订单号
			amount			订单金额	是	订单金额，元
			transaction_id	交易流水号	是	平台订单号
			datetime		交易时间	是	订单交易时间
			returncode		交易状态	是	00-成功
			attach			扩展返回	否	商户附加数据返回
			sign			签名		否	详情参见签名算法
		 */
		String memberid = request.getParameter("memberid");
		String orderid = request.getParameter("orderid");
		String amount = request.getParameter("amount");
		String transaction_id = request.getParameter("transaction_id");
		String datetime = request.getParameter("datetime");
		String returncode = request.getParameter("returncode");
		String attach = request.getParameter("attach");
		String sign = request.getParameter("sign");
		log.info("【收到小额话费回调参数：，memberid="+memberid+"，orderid="+orderid+""
				+ "，amount="+amount+""
				+ "，transaction_id="+transaction_id+""
				+ "，datetime="+datetime+""
				+ "，returncode="+returncode+""
				+ "，attach="+attach+"】");
		if(StrUtil.isBlank(memberid) || StrUtil.isBlank(orderid)|| StrUtil.isBlank(amount)|| StrUtil.isBlank(transaction_id)|| StrUtil.isBlank(attach)) {
			log.info("【必传参数为空】");
			return;
		}
		log.info("【开始验签】");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberid", memberid);
		map.put("orderid", orderid);
		map.put("amount", amount);
		map.put("transaction_id", transaction_id);
		map.put("returncode", returncode);
		map.put("datetime", datetime);
		String key = settingFile.getName("xiaoEHuaFei_alipay_key");
		String createParam = xiaoEHuaFeiUtil.createParam(map, key);
		String md5 = xiaoEHuaFeiUtil.md5(createParam);
		String newA = md5.toUpperCase();
		log.info("大写转换：" + newA);
		if(newA.equals(sign)) {
			log.info("【验签成功，我方验签结果："+newA+"，请求方加签结果："+sign+"】");
			response.getWriter().write("success");
		}else {
			log.info("【验签失败，我方验签结果："+newA+"，请求方加签结果："+sign+"】");
			return;
		}
		if("00".equals(returncode)) {//成功
			log.info("【交易成功】");
			DealOrder orderId = orderServiceImpl.findOrderByOrderId(orderid);
			String orderAll = orderId.getAssociatedId();
			boolean updataOrder = orderUtil.updataOrder(orderAll);
			if(updataOrder) {
				log.info("【订单状态和账户资金修改成功，全局订单号："+orderAll+"，现在开始发送通知】");
				notifyUtil.sendMsg(orderAll,updataOrder);
			}else {
				log.info("【订单状态和账户资金修改失败，全局订单号："+orderAll+"，现在开始发送通知】");
				notifyUtil.sendMsg(orderAll,updataOrder);
			}
			return;
		}else {//失败
			log.info("【交易失败】");
			DealOrder orderId = orderServiceImpl.findOrderByOrderId(orderid);
			boolean flag = orderServiceImpl.updataOrderEr(orderId.getOrderId());
			notifyUtil.sendMsg(orderId.getAssociatedId(),false);
			return;
		}
	}
}
