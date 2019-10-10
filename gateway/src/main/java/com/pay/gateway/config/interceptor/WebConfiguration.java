package com.pay.gateway.config.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pay.gateway.util.SettingFile;

import cn.hutool.core.io.FileUtil;
import cn.hutool.setting.Setting;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
	Logger log = LoggerFactory.getLogger(WebConfiguration.class);
	@Autowired
	SettingFile settingFile;
	 	@Autowired
	    private MyInterceptor  inteceptor;
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {	    //	/gateway/src/main/webapp/WEB-INF/jsp/kent.setting
	    	log.info("--------------------->>加载自定义拦截器-----");
	       registry.addInterceptor(inteceptor);
	    }
	 
}