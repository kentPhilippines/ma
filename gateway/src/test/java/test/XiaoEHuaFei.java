package test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pay.gateway.entity.dealEntity.ResultDeal;

import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;

public class XiaoEHuaFei {
	public static void main(String[] args) {
		ResultDeal result = new ResultDeal();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> careteParam = new HashMap();
		/**
		 * 	
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
		String pay_type = "alipay" ;       // settingFile.getName("xiaoEHuaFei_pay_type");// 支付宝H5
		String appid =  "10011";     ////settingFile.getName("xiaoEHuaFei_appid");
		String pay_notifyurl = "www.baidu.com";//settingFile.getName("xiaoEHuaFei_callback_url");
		String key ="ghx9zn5f3nhacleun90ps1z9ft62aenm";// settingFile.getName("xiaoEHuaFei_alipay_key");
		String url = "https://www.lakesun123.cn/Pay_Index.html";// settingFile.getName("xiaoEHuaFei_alipay_url");
		
		careteParam.put("pay_memberid", "10011");
		careteParam.put("pay_orderid", "789q79");
		careteParam.put("pay_applydate",formatter.format(new Date()));
		careteParam.put("pay_bankcode", "900");
		careteParam.put("pay_notifyurl", "www.baodu.com");
		careteParam.put("pay_callbackurl", "https://world.taobao.com/");
		careteParam.put("pay_amount", "100");
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
		
		
		
		
		
		
		
		
 
		System.out.println("请求未加密前："+param);
		String post = HttpUtil.post(url, careteParam);
		System.out.println(post);
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String md5(String param) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(param.getBytes());
            return new BigInteger(1,md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
	
	
	

}
