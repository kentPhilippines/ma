package com.pay.gateway.task;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
	/**
	 * 
	 * <p>定時任務</p>
	 * <li>1,修改賬戶每日資金凍結</li>
	 * <li>2,重新發送賬戶回調通知</li>
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 	@Scheduled(cron = "0/5 * * * * ?")
	    private void orderNotify() {
	        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	    }
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	

}
