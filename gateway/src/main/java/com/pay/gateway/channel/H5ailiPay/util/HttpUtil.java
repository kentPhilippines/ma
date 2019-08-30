package com.pay.gateway.channel.H5ailiPay.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	private static  RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000)
			.setConnectionRequestTimeout(15000).build();
 
	public static String sendHttpsGet(String url, List<NameValuePair> params) {
		HttpGet httpGet;// 创建get请求
 
		if (params == null || params.isEmpty()) {
			httpGet = new HttpGet(url);
		} else {
			List<NameValuePair> parameters = new LinkedList<NameValuePair>();
			for (NameValuePair param : params) {
				if (StringUtils.isEmpty(param.getName()))
					continue;
				parameters.add(param);
			}
 
			if (!url.contains("?")) {
				url += "?" + URLEncodedUtils.format(parameters, "UTF-8");
			} else {
				url += "&" + URLEncodedUtils.format(parameters, "UTF-8");
			}
			System.out.println(url);
			httpGet = new HttpGet(url);
		}
		return sendHttpGet(httpGet);
	}
 
	/**
	 * 发送Get请求
	 * 
	 * @param httpPost
	 * @return
	 */
	private static String sendHttpGet(HttpGet httpGet) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpGet.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
 
	public static String sendHttpsPost(String url, List<NameValuePair> params) {
		HttpPost httpPost;// 创建get请求
 
		httpPost = new HttpPost(url);
		if (params != null && params.size() > 0) {
			List<NameValuePair> parameters = new LinkedList<NameValuePair>();
			for (NameValuePair param : params) {
				if (StringUtils.isEmpty(param.getName()))
					continue;
				parameters.add(param);
			}
			UrlEncodedFormEntity form = null;
			try {
				form = new UrlEncodedFormEntity(parameters, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
			httpPost.setEntity(form);
		}
 
		return sendHttpPost(httpPost);
	}
 
	private static String sendHttpPost(HttpPost httpPost) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpPost.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
	
	public static void main(String[] args) {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("url", "http://127.0.0.1:8080/g-uc/notice.jsp"));
		
		System.out.println(sendHttpsGet("http://tinyurl.com/api-create.php", params));;
	}
	
}
