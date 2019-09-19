package com.pay.gateway.channel.H5ailiPay.contorller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.gateway.api.DealContorller;
import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.channel.H5ailiPay.util.QRCodeUtil;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.redis.RedisUtil;
import com.pay.gateway.entity.BankCard;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.JsonResult;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
@Controller
@RequestMapping("/api")
public class PayContorller {
	private final String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAu0wb+QnOIwVPMj3hs1Q6pFuLLdQFdc9baTRMPw6X+x3Lhmrk16AGep6ggcvFKEAWyZmyg33gmgZwJMGoWj1utQIDAQABAkB9lv5W0p1X3FKLhPUX043y8bN0ymvS4HUSKVBLJBUC+4GUpH4ng/4NkA3hYoa91AJfK/kQ7PTuTNIbdzUzLkntAiEA/uQS8RMT41P/ZUQofiDDgUGRuFgL+vsOgR387QextfMCIQC8HL3wlkZfwvcVKDuQ5OEICpzc8Ci2ZfTEogPnrluqtwIhAL620CVo7NyPIO0YTmPxB9dSxEF2P6CO8I9TbMe9lg5ZAiEAhGV+UcySr2ebW6q7cdmFgJFnoiDtpqLPyW12biPLpLUCIDU0PmBhO3nomUgNdUwyQESFPBKh0T9Y0w3Dh1x8mb/F\r\n" ; 
	private final String publicKey ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALtMG/kJziMFTzI94bNUOqRbiy3UBXXPW2k0TD8Ol/sdy4Zq5NegBnqeoIHLxShAFsmZsoN94JoGcCTBqFo9brUCAwEAAQ==\r\n"; //new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
	 @Value("${deal.url.path}")
	 private String dealurl;
	 @Value("${tomcat.imgpath.path}")
	 private String imgpath;
	 @Autowired
	 RedisUtil redisUtil;
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	BankCardService bankCardServiceImpl;
	 Logger log = LoggerFactory.getLogger(PayContorller.class);
	/**
	 * <p>跳转到PC二维码页面</p>
	 * @return
	 */
	@GetMapping("/startOrder")
	public String startOrder(String order ,String amount,Model m,HttpServletRequest request) throws Exception {
		 String serverName = request.getServerName();
		 int serverPort = request.getServerPort();
		 log.info("================【页面展示：金额："+amount+"，订单号："+order+"】===============");
		 String[] split = amount.split(",");
		 amount = split[0];
		 /**
		  * <p>生成二维码到本地</p>
		  */
		  QRCodeUtil.encode(
				"alipays://platformapi/startapp?appId=20000067&url="+serverName+":"+serverPort+"/api/payAli"+"?order="+order+"&amount="+amount,
				imgpath,
				true,order);
		m.addAttribute("order", order);
		m.addAttribute("amount", amount);
		 log.info("================【页面展示：金额："+amount+"，订单号："+order+"】===============");
		return "/pc";
	}
	/**
	 * <p>生成支付宝类的连接跳转</p>
	 * @param order
	 * @param amount
	 * @param m
	 * 這裏要查找銀行卡來生成支付寳的跳轉鏈接
	 */
	@GetMapping("/payAli")
	public String payAli(@RequestParam("order")String order ,@RequestParam("amount")String amount,Model m) {
		log.info("================【飞行页面转发】===============");
		m.addAttribute("order", order);//订单号
		m.addAttribute("amount", amount);//金额
		return "/alipay";
	}
	
	
	/**
	 * <p>自執行函數一部請求生成訂單和請求支付包鏈接</p>
	 * @param order
	 * @param amount
	 * @param m
	 * @return
	 */
	@ResponseBody
	@PostMapping("/createOrder")
	@Transactional
	public JsonResult createOrder(@RequestParam("order")String order ,@RequestParam("amount")String amount,Model m) {
		log.info("=========【全局訂單:order="+order+"，全局訂單金額：amount="+amount+"，正在生成訂單】============");
		DealOrder dealOrder = orderServiceImpl.findOrderByOrderAll(order);
		if(ObjectUtil.isNotNull(dealOrder)) {//当订单存在的时候不在创建直接返回订单相关信息从缓存中获取当前
			if(Common.ORDERDEASTATUS_T.equals(dealOrder.getOrderStatus())) {
				log.info("|------【当前订单已生成，进入金额筛选算法，订单号为："+dealOrder.getOrderId()+"】");
				BankCard bankcard = bankCardServiceImpl.findBankCardByBankCardId(dealOrder.getDealCardId());
				String object = (String) redisUtil.get(bankcard.getBankPhone());
				ArrayList<String> bankListuse = CollUtil.newArrayList(object.toString());//该银行卡目前正在使用的所有的key    key = 银行唯一标识(非卡号) + 交易金额    value = 全局订单号
				for( String key : bankListuse) {
					Object object2 = redisUtil.get(key);
					if(null != object2) {
						if(dealOrder.getAssociatedId().equals(object2)) {//当 value和全局订单号相等的时候
							String amountK = StrUtil.subSuf(key.toString(),Common.BANKCARD_AMOUNT_BUMBER-1);//金额
							bankcard.setDealAmount(new BigDecimal(amountK));
							return JsonResult.buildSuccessResult(bankcard);
						}
					}
				}
			}else {
				return JsonResult.buildFailResult();
			}
		}
		BankCard bankCard = orderServiceImpl.createOrder(order,amount);
		if(ObjectUtil.isNotNull(bankCard)) {
			return JsonResult.buildSuccessResult(bankCard);
		}
		log.info("=========【交易订单生成失败】============");
		return null;
	}
	
	
	

}
