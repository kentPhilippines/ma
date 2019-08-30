package com.pay.gateway.config.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MyConfiguration implements WebMvcConfigurer{
	
    @Value("${tomcat.imgpath.path}")
    private String imgpath;
	
	
	/**
     * 虚拟路径配置
     * @param registry
     */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/fileImg/**").addResourceLocations(imgpath);
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
