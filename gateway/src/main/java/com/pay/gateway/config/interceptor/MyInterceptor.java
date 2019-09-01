package com.pay.gateway.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * <p>可以作为拦截器使用</p>
 * <li>1,可以通过注解判断拦截</li>
 * <li>2,可以记录日志</li>
 * <li>3,修改请求参数</li>
 * <li>4,目前没有什么卵用</li>
 * @author K
 * 2019-08-03
 */
@Component
public class MyInterceptor   implements HandlerInterceptor {
	Logger log = LoggerFactory.getLogger(MyInterceptor.class);
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		req.setAttribute("ctx", req.getContextPath());//前端全局变量
		resp.setContentType("text/html;charset=utf-8"); 
		resp.setCharacterEncoding("utf-8");
		log.info("MyInterceptor01--->postHandle()执行控制器之后且在渲染视图前调用此方法....");
	}
}
