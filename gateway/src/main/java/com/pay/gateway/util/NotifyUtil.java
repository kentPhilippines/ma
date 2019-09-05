package com.pay.gateway.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.channel.H5ailiPay.contorller.NotfiyContorller;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.OrderService;

/**
 * <p>給下游商戶發送通知</p>
 * @author K
 */
@Service
public class NotifyUtil {
	Logger log = LoggerFactory.getLogger(NotifyUtil.class);
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	AccountService accountServiceImpl;
	/**
	 * <p>根據訂單號給下游發送通知</p>
	 * @param OrderId		訂單號
	 * @param flag			成功或失敗的通知
	 */
	public void sendMsg(String OrderIdAll,boolean flag) {
		log.info("============【準備向享有發送通知】================");
		DealOrder dealOrder = orderServiceImpl.findOrderByOrderAll(OrderIdAll);
		String url = dealOrder.getRetain1();
		Account account = accountServiceImpl.findAccountByAppId(dealOrder.getOrderAccount());
		AccountInfo accountInfo = accountServiceImpl.findAccountInfoByAppId(dealOrder.getOrderAccount());
		String appid =   account.getAccountId();
		String secretKey = accountInfo.getAppKey(); 
		String orderNo = dealOrder.getOrderId(); // 本系統訂單號
		String externalOrderId = dealOrder.getExternalOrderId(); // 外部訂單號  (就是下有商戶的訂單號)
		String amount = dealOrder.getDealAmount().toString();
		String sign = appid + orderNo + amount + externalOrderId + secretKey;
		sign =  md5(sign);
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("appid", appid);
		msg.put("orderNo", orderNo);
		msg.put("amount", amount);
		msg.put("externalOrderId", externalOrderId);
		msg.put("sign", sign);
		log.info("============【發送通知的參數情況："+msg.toString()+"】================");
		log.info("============【發送通知的地址："+url.toString()+"】================");
		send(url,msg);
	}
	
	/**
	 * <p>發送通知</p>
	 * @param url			發送通知的地址
	 * @param msg			發送通知的内容
	 */
	private void send( String url, Map<String, String> msg ) {
		String createParam = createParam(msg);
		String submitPost = submitPost(url,createParam);
		String orderNo = msg.get("orderNo");
		if("suss".equalsIgnoreCase(submitPost)) {//修改訂單通知
			boolean flag = orderServiceImpl.updataNotifyYesByNo(orderNo);
			if(flag)
				log.info("============【發送通成功，訂單發送通知狀態已修改為YES：orderNo："+orderNo+"】================");
		}
		
	}
	public  static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            return new BigInteger(1,md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	public static String submitPost(String url, String params) {
		StringBuffer responseMessage = null;
		java.net.HttpURLConnection connection = null;
		java.net.URL reqUrl = null;
		OutputStreamWriter reqOut = null;
		InputStream in = null;
		BufferedReader br = null;
		int charCount = -1;
		try {
			responseMessage = new StringBuffer(128);
			reqUrl = new java.net.URL(url);
			connection = (java.net.HttpURLConnection) reqUrl.openConnection();
			connection.setReadTimeout(50000);
			connection.setConnectTimeout(100000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			reqOut = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			reqOut.write(params);
			reqOut.flush();
			in = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			while ((charCount = br.read()) != -1) {
				responseMessage.append((char) charCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (reqOut != null) {
					reqOut.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseMessage.toString();
	}
	public static String createParam(Map<String, String> paramMap) {
		try {
			if (paramMap == null || paramMap.isEmpty()) {
				return null;
			}
			Object[] key = paramMap.keySet().toArray();
			Arrays.sort(key);
			StringBuffer res = new StringBuffer(128);
			for (int i = 0; i < key.length; i++) {
				res.append(key[i] + "=" + paramMap.get(key[i]) + "&");
			}
			String rStr = res.substring(0, res.length() - 1);
			System.out.println("请求接口加密原串 = " + rStr);
			return rStr ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
