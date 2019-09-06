package com.pay.gateway.task;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pay.gateway.api.DealContorller;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.OrderService;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
	Logger log = LoggerFactory.getLogger(SaticScheduleTask.class);
	@Autowired
	private OrderService orderServiceImpl;
	
	@Autowired
	AccountService accountServiceImpl;
	
	
	/**
	 * <p>定時任務</p>
	 * <li>1,修改賬戶每日資金凍結</li>
	 * <li>2,重新發送賬戶回調通知</li>
	 */
	 	@Scheduled(cron = "0/5 * * * * ?")
	    private void orderNotify() {
	        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	    }
	 	
	 	/**
	 	 * <p>凌晨6	點修改賬戶凍結餘額</p>
	 	 */
	 	@Scheduled(cron = "0 0 6 * * ?")
	 	 private void account() {
	 		accountServiceImpl.updataAccountAmount();
	 		log.info("=================【修改賬戶凍結金額: " + LocalDateTime.now()+"】===============");
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	

}
