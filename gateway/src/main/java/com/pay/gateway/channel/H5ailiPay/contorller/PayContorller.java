package com.pay.gateway.channel.H5ailiPay.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pay.gateway.api.DealContorller;
import com.pay.gateway.channel.H5ailiPay.util.QRCodeUtil;
@Controller
@RequestMapping("/api")
public class PayContorller {
	 @Value("${deal.url.path}")
	 private String dealurl;
	 @Value("${tomcat.imgpath.path}")
	 private String imgpath;
	 Logger log = LoggerFactory.getLogger(PayContorller.class);
	/**
	 * <p>跳转到PC二维码页面</p>
	 * @return
	 * @throws Exception 
	 */
	 @PostMapping("/startOrder")
	public String startOrder(@RequestParam("order")String order ,@RequestParam("amount")String amount,Model m) throws Exception {
		 log.info("================【页面展示：金额："+amount+"，订单号："+order+"】===============");
		QRCodeUtil.encode(
				"alipays://platformapi/startapp?appId=20000067&url="+dealurl+"?order="+order+"&amount="+amount,
				"C:/Users/ADMIN/Pictures/Feedback/{5F6E618A-0465-4906-B660-E1115B4E2DEC}/Capture001.png", 
				imgpath,
				true,order);
		m.addAttribute("order", order);
		m.addAttribute("amount", amount);
		return "/pc";
		
	}
	
	/**
	 * <p>这次访问成生订单</p>
	 * @param order
	 * @param amount
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/payAli")
	public String payAli(@RequestParam("order")String order ,@RequestParam("amount")String amount,Model m) throws Exception {
		QRCodeUtil.encode(
				"alipays://platformapi/startapp?appId=20000067&url="+dealurl+"?order="+order+"&amount="+amount,
				"C:/Users/ADMIN/Pictures/Feedback/{5F6E618A-0465-4906-B660-E1115B4E2DEC}/Capture001.png", 
				imgpath,
				true,order);
		m.addAttribute("order", order);
		m.addAttribute("amount", amount);
		return "/pc";
	}
	
	
	
	

}
