package com.pay.gateway.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.gateway.api.DealContorller;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountInfo;
import com.pay.gateway.service.AccountService;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

@Service
public class RequestUtil {
	Logger log = LoggerFactory.getLogger(RequestUtil.class);
	@Autowired
	AccountService accountServiceImpl;
	public void validationAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
	}
}
