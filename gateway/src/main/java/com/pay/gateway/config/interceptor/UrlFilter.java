package com.pay.gateway.config.interceptor;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Struct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.service.AccountService;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * Servlet Filter implementation class NdcFilter
 */
@Order(1)
@WebFilter(filterName = "UrlFilter", urlPatterns = "/*")
public class UrlFilter  implements Filter {
	@Autowired
	AccountService accountServiceImpl;
	
	
	Logger log = LoggerFactory.getLogger(UrlFilter.class);
    public UrlFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		 log.info("|-----------------【进入项目拦截器】-----------------------");
		 log.info("访问URL：" + request.getRequestURL());
		 log.info("请求参数字符编码: " + request.getCharacterEncoding());
		 if(StrUtil.isBlank(request.getCharacterEncoding())) { 
			 log.info("|--------------【15030 :字符编码未设置】----------------");
			 response.getWriter().write("15030--字符编码未设置");
			 return;
		 }
		 if(!Common.CODING.equalsIgnoreCase(request.getCharacterEncoding())) {
			 log.info("|--------------【15031 :字符编码错误】----------------");
			 response.getWriter().write("15031--请将字符编码设置为UTF-8");
			 return;
		 }
		 String appid = request.getParameter("appid");
		 if(StrUtil.isBlank(appid)) {
			 log.info("------------------------------【必传参数为空】------------------------------");
				response.getWriter().write("15034--必传参数为空");
				return;
		 }
		 Account account = accountServiceImpl.findAccountByAppId(appid);
		 if(ObjectUtil.isNull(account)) {
			 log.info("|--------------【15020 ：用户不存在】----------------");
			 response.getWriter().write("15020--用户不存在");
			 return;
		 }
		 String applydate = request.getParameter("applydate");
		 DateFormat formatter = new SimpleDateFormat(Common.DATATYPE);
		 Date date;
		try {
			date = formatter.parse(applydate);
			boolean expired = DateUtil.isExpired(date,DateField.SECOND,60000,new Date());//请求10秒过期
			if(!expired) {
				 log.info("|--------------【15033 ：请求过期】----------------");
				 response.getWriter().write("15033--请求过期");
				 return;
			}
		} catch (ParseException e1) {
			 log.info("|--------------【15032 ：时间格式错误】----------------");
			 response.getWriter().write("15032--时间格式错误");
			 return;
		}
		 AccountInfo accountInfo = accountServiceImpl.findAccountInfoByAppId(appid);
		 if(ObjectUtil.isNull(accountInfo)) {
			 log.info("|--------------【15020 ：用户不存在】----------------");
			 response.getWriter().write("15020--用户不存在");
			 return;
		 }
		 log.info("|--------------【用户开始验签】----------------");
		 String appKey = accountInfo.getAppKey();
		 String appDesKey = accountInfo.getAppDesKey();
		 String rsasign = request.getParameter("rsasign");
		 try {
			//boolean verify = verify(request,appDesKey,rsasign);
			 boolean verify = true;
			if(verify)
				log.info("|--------------【验签正常】----------------");
			else {
				log.info("|--------------【验签失败】----------------");
				response.getWriter().write("15010--验签失败");
			}
		} catch (Exception e) {
			 log.info("|--------------【验签异常】----------------");
			 response.getWriter().write("15010--验签失败");
			 return;
		}
		 chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	/**
     * 验签
     * 
     * @param srcData 原始字符串
     * @param publicKey 公钥
     * @param sign 签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        boolean verify = signature.verify(Base64.decodeBase64(sign.getBytes()));
        return verify;
    }
	private boolean verify(HttpServletRequest request, String appDesKey, String rsasign) throws Exception {
		String appid = request.getParameter("appid");
		String orderid = request.getParameter("orderid");
		String applydate = request.getParameter("applydate");
		String notifyurl = request.getParameter("notifyurl");
		String amount = request.getParameter("amount");
		StringBuilder sb=new StringBuilder();
		sb.
		append("appid").append("=").
		append(appid).append("&").
		append("orderid").append("=").
		append(orderid).append("&").
		append("applydate").append("=").
		append(applydate).append("&").
		append("notifyurl").append("=").
		append(notifyurl).append("&").
		append("amount").append("=").
		append(amount).append("&");
		boolean verify = verify(sb.toString(),getPublicKey(appDesKey),rsasign);
		return verify;
	}
	/**
     * 获取公钥
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        PublicKey generatePublic = keyFactory.generatePublic(keySpec);
        return generatePublic;
    }
}
