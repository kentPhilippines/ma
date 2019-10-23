package com.pay.gateway.channel.xiaoEHuaFei.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pay.gateway.channel.H5ailiPay.service.BankCardService;
import com.pay.gateway.channel.H5ailiPay.util.BankUtil;
import com.pay.gateway.channel.pinDuoDuo.entity.Data;
import com.pay.gateway.channel.pinDuoDuo.entity.PinDuoDuo;
import com.pay.gateway.channel.xiaoEHuaFei.entity.XiaoEHuaFei;
import com.pay.gateway.channel.xiaoEHuaFei.entity.XiaoeHuaFeiDate;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.service.PayOrderService;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.util.SendUtil;
import com.pay.gateway.util.SettingFile;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
@Component("xiaoEHuaFeiAlipayH5")
public class AlipayH5 extends PayOrderService{
	Logger log = LoggerFactory.getLogger(AlipayH5.class);
	@Autowired
	BankCardService bankCardServiceImpl;
	@Autowired
	OrderService orderServiceImpl;
	@Resource
	BankUtil bankUtil;
	@Autowired
	SendUtil sendUtil;
	@Autowired
	SettingFile settingFile;
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public ResultDeal deal(Deal deal, Account account, AccountFee accountFee, OrderAll orderAll) {
		log.info("===========【进入拼多多支付业务处理类】======");
		ResultDeal result = new ResultDeal();
		String dealAmount = orderAll.getOrderAmount();//用户提交金额
		boolean flag = orderServiceImpl.createOrderNoBankCaed(orderAll.getOrderId(),dealAmount);
		DealOrder order = null;	
		if(flag) {
			log.info("【拼多多支付模式交易订单创建成功】");
			order = orderServiceImpl.findOrderByOrderAll(orderAll.getOrderId());
		}else {
			result.setCod(Common.RESPONSE_STATUS_ER);
			result.setMsg(Common.RESPONSE_STATUS_ER_MSG);
			result.setRedirect("订单创建失败，请联系运营人员处理");
			return result;
		}
		return Post(order);
	}

	private ResultDeal Post(DealOrder order) {
		ResultDeal result = new ResultDeal();
		Map<String, Object> careteParam = new HashMap();
		/**
		 * 	
		pay_memberid	商户号			是	是	平台分配商户号
		pay_orderid		订单号			是	是	上送订单号唯一，字符长度20
		pay_applydate	提交时间		是	是	时间格式：2016-12-26 18:18:18
		pay_bankcode	支付通道		是	是	平台支付通道，详见支付通道
		pay_notifyurl	服务端通知		是	是	支付成功后异步通知地址（POST参数）
		pay_callbackurl	页面跳转		是	是	支付成功后页面跳转地址
		pay_amount		订单金额		是	是	商品金额，元
		
		pay_md5sign		MD5签名			是	否	详见签名算法
		pay_productname	商品名称		是	否	商品名称展示
		pay_attach		附加字段		否	否	此字段在返回时按原样返回 (中文url编码)
		pay_productnum	商品数量		否	否	商品数量展示
		pay_productdesc	商品描述		否	否	商品描述展示
		pay_producturl	商品链接地址	否	否	商品链接地址展示
		format			请求返回格式	否	否	选填，固定值json，详见请求返回说明
		 */
		String pay_type = settingFile.getName("xiaoEHuaFei_pay_type");// 支付宝H5
		String appid = settingFile.getName("xiaoEHuaFei_appid");
		String pay_notifyurl = settingFile.getName("xiaoEHuaFei_callback_url");
		String key = settingFile.getName("xiaoEHuaFei_alipay_key");
		String url = settingFile.getName("xiaoEHuaFei_alipay_url");
		careteParam.put("pay_memberid", appid);
		careteParam.put("pay_orderid",  order.getOrderId());
		careteParam.put("pay_applydate",formatter.format(new Date()));
		careteParam.put("pay_bankcode",pay_type);
		careteParam.put("pay_notifyurl", pay_notifyurl);
		careteParam.put("pay_callbackurl", "https://world.taobao.com/");
		careteParam.put("pay_amount", order.getDealAmount());
		String param = createParam(careteParam,key);
		String md5 = md5(param);
		String newA = md5.toUpperCase();
		System.out.println("大写转换：" + newA);
		careteParam.put("pay_md5sign", newA);
		careteParam.put("pay_productname", "商品");
		careteParam.put("pay_attach", "app");
		careteParam.put("pay_productnum", "1");
		careteParam.put("pay_productdesc", "商品");
		careteParam.put("pay_producturl", "app");
		careteParam.put("format", "json");
		log.info("请求未加密前："+param);
		String post = HttpUtil.post(url, careteParam);
		if(post.contains("returncode")) {
			JSONObject parseObj = JSONUtil.parseObj(post);
			XiaoEHuaFei bean = JSONUtil.toBean(parseObj, XiaoEHuaFei.class);
			if("00".equals(bean.getReturncode())) {
				result.setCod(Common.RESPONSE_STATUS_SU);
				result.setMsg(Common.RESPONSE_STATUS_SU_MSG);
				result.setReturnUrl(bean.getQrcode());
				result.setOpenType(Common.OPENTYPE_URL);
				return result;
			}
		} 
			DealOrder orderId = orderServiceImpl.findOrderByOrderId(order.getOrderId());
			orderServiceImpl.updataOrderEr(orderId.getOrderId());
			result.setCod(Common.RESPONSE_STATUS_ER);
			result.setMsg(Common.RESPONSE_STATUS_ER_MSG );
		return result;
	}

	public static String md5(String str){
		  MessageDigest md5 = null;  
		  try{  
		     md5 = MessageDigest.getInstance("MD5");  
		  }catch (Exception e){  
		    System.out.println(e.toString());  
		    e.printStackTrace();  
		    return "";  
		  }  
		  char[] charArray = str.toCharArray();  
		  byte[] byteArray = new byte[charArray.length];
		  for (int i = 0; i < charArray.length; i++)  
		    byteArray[i] = (byte) charArray[i];  
		  byte[] md5Bytes = md5.digest(byteArray);  
		  StringBuffer hexValue = new StringBuffer();  
		  for (int i = 0; i < md5Bytes.length; i++){  
		    int val = ((int) md5Bytes[i]) & 0xff;  
		    if (val < 16)  
		      hexValue.append("0");  
		    hexValue.append(Integer.toHexString(val));  
		  }  
		  return hexValue.toString();
		}

	private String createParam(Map<String, Object> map, String appInitKey) {
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
				return rStr + "&key=" + appInitKey;
			}
			return rStr + "&key=" + appInitKey;                                                                                                                                                                                                                                
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

