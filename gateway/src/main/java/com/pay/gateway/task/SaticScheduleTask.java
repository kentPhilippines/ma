package com.pay.gateway.task;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pay.gateway.api.MyDealContorller;
import com.pay.gateway.channel.H5ailiPay.util.BankUtil;
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
	@Autowired
	BankUtil bankUtil;
	/**
	 * <p>定時任務</p>
	 * <li>1,修改賬戶每日資金凍結</li>
	 * <li>2,重新發送賬戶回調通知</li>
	 * <li>3,修改订单为失败  4分钟之前的订单修改为失败</li>
	 */
		/**
		 * <p>5秒钟修改一次订单状态</p>
		    */
	/*
	 * @Scheduled(cron = "0/5 * * * * ?") private void orderNotify() { Integer
	 * second = bankUtil.getSecond() ;
	 * log.info("=================【修改订单状态为未收到回调，获取时间为: " +
	 * second+"【秒】】==============="); orderServiceImpl.updataOrderStatus(second); }
	 */
	 	/**
	 	 * <p>凌晨6	点修改账户冻结余额</p>
	 	 */
	 	@Scheduled(cron = "0 0 6 * * ?")
	 	 private void account() {
	 		accountServiceImpl.updataAccountAmount();
	 		log.info("=================【修改賬戶凍結金額: " + LocalDateTime.now()+"】===============");
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	

}
