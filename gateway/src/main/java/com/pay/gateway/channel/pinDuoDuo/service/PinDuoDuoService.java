package com.pay.gateway.channel.pinDuoDuo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.channel.H5ailiPay.util.BankUtil;
import com.pay.gateway.channel.ailipayToCard.service.AiliPayToCardServiceImpl;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.service.PayOrderService;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.SendUtil;

@Component("PinDuoDuoService")
public class PinDuoDuoService extends PayOrderService{
	Logger log = LoggerFactory.getLogger(PinDuoDuoService.class);
	@Autowired
	BankCardService bankCardServiceImpl;
	@Autowired
	OrderService orderServiceImpl;
	@Resource
	BankUtil bankUtil;
	@Autowired
	SendUtil sendUtil;
	@Override
	public ResultDeal deal(Deal deal, Account account, AccountFee accountFee, OrderAll orderAll) {
		log.info("===========【进入拼多多支付业务处理类】======");
		ResultDeal result = new ResultDeal();
		String dealAmount = orderAll.getOrderAmount();//用户提交金额
		boolean flag = orderServiceImpl.createOrderNoBankCaed(orderAll.getOrderId(),dealAmount);
		if(flag) {
			log.info("【拼多多支付模式交易订单创建成功】");
		}else {
			result.setCod(Common.RESPONSE_STATUS_ER);
			result.setMsg(Common.RESPONSE_STATUS_ER_MSG);
			result.setRedirect("订单创建失败，请联系运营人员处理");
			return result;
		}
		return Post();
	}
	private ResultDeal Post() {
		Map<String, Object> careteParam = new HashMap();
		/**
		 * 	pay_memberid 		商户号 		int 	Y Y 商户号mchid
			pay_orderid 		商户订 单号	 	string 	Y Y 上送订单号唯一，不能有特殊字符
			pay_applydate 		提交时 间 		string 	Y Y 时间格式：2016-12-26 18:18:18
			pay_bankcode 		支付类 型编码 	string 	Y Y 如：614，请参照附件中支付代码
			pay_notifyurl 		异步通 知地址 	string 	Y Y 支付完成后异步通知的地址
			pay_callbackurl 	页面跳 转地址 	string 	Y Y 暂不支持支付完成后同步回调,提交不 为空的值即可，如666
			pay_amount 			支付金 额 		float 	Y Y 订单金额，最多2位小数
			pay_md5sign 		请求签 名 		string 	Y N 请求签名
			pay_productname 	商品名 称 		string 	Y N 支付说明
			pay_attach 			附加信 息 		string 	N N 附加信息
		 */
		careteParam.put("pay_memberid", "");
		careteParam.put("pay_orderid", "");
		careteParam.put("pay_applydate", "");
		careteParam.put("pay_bankcode", "");
		careteParam.put("pay_notifyurl", "");
		careteParam.put("pay_callbackurl", "");
		careteParam.put("pay_amount", "");
		careteParam.put("pay_md5sign", "");
		careteParam.put("pay_productname", "");
		careteParam.put("pay_attach", "");
		return null;
	}
	/**
	 * 	614 支付宝H5(pdd模式)
		619 微信H5(pdd模式)
		620 话费支付宝H5(pdd模式)
	 */

	
	
	public String createParam(Map<String, String> map, String appInitKey) {
		try {
			if (map == null || map.isEmpty()) {
				return null;
			}
			//对参数名按照ASCII升序排序
			Object[] key = map.keySet().toArray();
			Arrays.sort(key);
			//生成加密原串  
			StringBuffer res = new StringBuffer(128);
			for (int i = 0; i < key.length; i++) {
				res.append(key[i] + "=" + map.get(key[i]) + "&");
			}
			String rStr = res.substring(0, res.length() - 1);
			System.out.println("请求接口加密原串 = " + rStr);
			if (appInitKey == null) {
				return rStr + "&hmac=" + getKeyedDigest(rStr, "");
			}
			return rStr + "&hmac=" + getKeyedDigestUTF8(rStr, appInitKey);                                                                                                                                                                                                                                
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	private String getKeyedDigestUTF8(String rStr, String appInitKey) {
		return null;
	}
	private String getKeyedDigest(String rStr, String string) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
