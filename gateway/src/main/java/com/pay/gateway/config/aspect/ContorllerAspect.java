package com.pay.gateway.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pay.gateway.service.AccountService;
@Aspect
@Component
public class ContorllerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AccountService accountServiceImpl;
	  	@Pointcut("execution(public * com.pay.gateway.api.DealContorller..*(..))")
	    public void systemLog() {}
	    @Around(value = "systemLog()")
	    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
	    	log.info("===============【交易类aop】==================");
	    	joinPoint.proceed();//执行方法
	    }

}
