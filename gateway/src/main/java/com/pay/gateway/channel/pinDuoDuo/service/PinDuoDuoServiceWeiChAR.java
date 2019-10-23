package com.pay.gateway.channel.pinDuoDuo.service;

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
@Component("PinDuoDuoServiceWeiChAR")
public class PinDuoDuoServiceWeiChAR extends PayOrderService{
	Logger log = LoggerFactory.getLogger(PinDuoDuoServiceWeiChAR.class);
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
		String appId = settingFile.getName("pinDuoDuoAppId");
		String product = settingFile.getName("pinDuoDuoProduct_type_weichar");// 微信
		String url = settingFile.getName("pinDuoDuo_url");
		String key = settingFile.getName("pinDuoDuo_key");
		String pay_notifyurl = settingFile.getName("pinDuoDuopay_notifyurl");
		careteParam.put("pay_memberid", appId);
		careteParam.put("pay_orderid", order.getOrderId());
		careteParam.put("pay_applydate", formatter.format(new Date()));
		careteParam.put("pay_bankcode",product);
		careteParam.put("pay_notifyurl", pay_notifyurl);
		careteParam.put("pay_callbackurl", "111");
		careteParam.put("pay_amount", order.getDealAmount());
		String param = createParam(careteParam,key);
		log.info("请求未加密前："+param);
		String md5 = md5(param);
		String newA = md5.toUpperCase();
		log.info("大写转换：" + newA);
		careteParam.put("pay_md5sign", newA);
		careteParam.put("pay_productname", "这是GBOO支付");
		careteParam.put("pay_attach", "这是GBOO支付");
		String post = HttpUtil.post(url, careteParam);
		JSONObject parseObj = JSONUtil.parseObj(post);
		PinDuoDuo bean = JSONUtil.toBean(parseObj, PinDuoDuo.class);
		if(bean.isStatus()) {//成功
			result.setCod(Common.RESPONSE_STATUS_SU);
			result.setMsg(bean.getMsg());
			JSONObject parseObj1 = JSONUtil.parseObj(bean.getData());
			Data data = JSONUtil.toBean(parseObj1, Data.class);
			result.setReturnUrl(data.getGateway());
			result.setOpenType(Common.OPENTYPE_URL);
		}else {//失败
			result.setCod(Common.RESPONSE_STATUS_ER);
			result.setMsg(bean.getMsg());
		}
		return result;
	}
	private static String createParam(Map<String, Object> map, String appInitKey) {
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
}
