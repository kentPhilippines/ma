package test;

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

public class pingduoduoTest {
	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		ResultDeal result = new ResultDeal();
		Map<String, Object> careteParam = new HashMap();
		 
		
		
		
		
		
		careteParam.put("pay_memberid", "15250");
		careteParam.put("pay_orderid",new Date().getTime());
		careteParam.put("pay_applydate", formatter.format(new Date()));
		careteParam.put("pay_bankcode","614");
		careteParam.put("pay_notifyurl", "http://www.baidu.com");
		careteParam.put("pay_callbackurl", "111");
		careteParam.put("pay_amount", "67.00");
		String param = createParam(careteParam,"ddtisnzft0vpnf3kqb8708n1p89xzol7");
		System.out.println("请求未加密前："+param);
		String md5 = md5(param);
		String newA = md5.toUpperCase();
		System.out.println("大写转换：" + newA);
		careteParam.put("pay_md5sign", newA);
		careteParam.put("pay_productname", "这是GBOO支付");
		careteParam.put("pay_attach", "这是GBOO支付");
		String post = HttpUtil.post("http://open.drupcloud.net/pay_index", careteParam);
		System.out.println(post);
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
