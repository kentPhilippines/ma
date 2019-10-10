package com.pay.gateway.channel.pinDuoDuo.notfiy;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pay.gateway.channel.pinDuoDuo.service.PinDuoDuoService;
import com.pay.gateway.service.OrderService;

@Controller
@RequestMapping("/pingDuoDuo")
public class PingDuoDuoNotfiy {
	Logger log = LoggerFactory.getLogger(PinDuoDuoService.class);
	@Autowired
	OrderService orderServiceImpl;
	
	
	@RequestMapping("/notfiy")
	public void notfiy(HttpServletRequest request) throws Exception {
		log.info("【进入拼多多回调处理】");
		/**
		 * 	memberid 		商户编码 		int 		Y 	平台商户号
			orderid 		订单号 		string 		Y 	商户订单号
			amount 			订单金额 		float 		Y 	订单金额
			transaction_id 	交易流水号 		string 		Y 	平台订单号
			datetime 		交易时间 		string 		Y 	返回时间
			returncode 		交易状态 		string 		Y 	"00"为成功
			attach 			扩展返回 		string 		N 	附加信息
			sign 			返回签名 		string 		N 	签名
		 */
		String memberid = request.getParameter("memberid");
		String orderid = request.getParameter("orderid");
		String amount = request.getParameter("amount");
		String transaction_id = request.getParameter("transaction_id");
		String datetime = request.getParameter("datetime");
		String returncode = request.getParameter("returncode");
		String attach = request.getParameter("attach");
		String sign = request.getParameter("sign");
		if("00".equals(returncode)) {//成功
			log.info("【交易成功】");
			return;
		}else {//失败
			log.info("【交易失败】");
			return;
		}
	}
}
