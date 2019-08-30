package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.pay.gateway.util.DateUtils;

import cn.hutool.core.lang.UUID;


public class request {
	public static void main(String[] args) throws Exception {
		Map<String, String> params = new HashMap();
		String appid = "AC1000";
		String orderid = UUID.randomUUID().toString();
		String applydate =  DateUtils.parseDate(DateUtils.FORMAT_TIME,new Date());
		String notifyurl = "www.baidu.com";
		String amount = "1000";
		String passcode = "ZIJI";
		String callbackurl = "WWW.BAIDU.COM";
		params.put("appid", appid);
		params.put("orderid", orderid);
		params.put("applydate", applydate);
		params.put("notifyurl", notifyurl);
		params.put("passcode", passcode);
		params.put("callbackurl", callbackurl);
		String url = "127.0.0.1:8080/deal/payH5Ali";
		String key = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAkfdV9/nLwEA5wgp+D/tmXXCyI4obkl4VrHGsyus8xE2+ERXKFaMjTXCVeNziqdQP0DwRDGwMY1k9l3xRA3X75wIDAQABAkAkQUDTJPJcwBcYgS6qnZDhaJp2hVkv07qiaGG4zRD82Mpk25NjciNBcut8kUQmNvu4Niz75Z2b3C/RHsUbGXghAiEAyCFegfQ1ABf0ZcCleA5d/Djo7boNOJXyK5sByfpvjikCIQC6twmHXhR76g6OZxYIcvZ4ga+34B80Z38bFlL8pFVbjwIhALEcjvX1OD539KtkPUwtctG3T7SrVe4BDYu3p3KndrhZAiEAg7tr76PC1AI4ruOwOdnSZwcokJSBr5ltphDEEBdpWaUCIQCLA6/qQgpQUsW9GCAIQOwmLuNK1QJ11LTbMYsB0K0How==";
		request req = new request();
		Map<String, String> invoke = req.invoke(params,url,key);
		System.out.println(invoke.toString());
	}
	public Map<String, String> invoke(Map<String, String> paramMap, String url, String appInitKey) throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();
		String params = getParam(paramMap, appInitKey);
		String result = submitPost(url, params);
		if (result == null) {
			return null;
		}
		System.out.println("【返回】："+result);
		System.out.println("---------");
		String[] split = result.split("&");
		for (int i = 0; i < split.length; i++) {
			String[] temp = split[i].split("=");
			if (temp.length == 1) {
				resultMap.put(temp[0], "");
			}
			if (temp.length > 1) {
				resultMap.put(temp[0], temp[1]);
			}
		}
		return resultMap;
	}
	public static String getParam(Map<String, String> formparams, String appInitKey) throws Exception{
		StringBuilder sb=new StringBuilder();
				sb.append("appid").append("=")//appid
				.append(null!= formparams.get("appid") ? formparams.get("appid"):"" ).append("&")//appid
				.append("orderid").append("=")//appid
				.append(null!= formparams.get("orderid")?formparams.get("orderid"):"").append("&")//orderid
				.append("applydate").append("=")//appid
				.append(null!= formparams.get("applydate")?formparams.get("applydate"):"").append("&")//applydate
				.append("notifyurl").append("=")//appid
				.append(null!= formparams.get("notifyurl")?formparams.get("notifyurl"):"").append("&")//notifyurl
				.append("amount").append("=")//appid
				.append(null!= formparams.get("amount")?formparams.get("amount"):"").append("&");//amount
		 		String sign = sign(sb.toString(), getPrivateKey(appInitKey));
		 		sb.append("&rsasign="+sign)
		 		.append("passcode").append("=")//appid
		 		.append(null!= formparams.get("passcode")?formparams.get("passcode"):"").append("&")//passcode
		 		.append("callbackurl").append("=")//appid
				.append(null!= formparams.get("callbackurl")?formparams.get("callbackurl"):"").append("");//callbackurl
		 		System.out.println("请求参数==================="+sb.toString());
		return sb.toString();
	}
	/**
     * 签名
     * @param data 待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(key);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }
	 public static PrivateKey getPrivateKey(String privateKey) throws Exception {
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
	        return keyFactory.generatePrivate(keySpec);
	    }
	
	 /**
		 * POST方法的提交方式
		 * @param url 请求地址
		 * @param params 请求参数
		 * @return
		 */
		public String submitPost(String url, String params) {
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

}
