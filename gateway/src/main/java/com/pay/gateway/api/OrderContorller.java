package com.pay.gateway.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pay.gateway.util.NotifyUtil;
import com.pay.gateway.util.OrderUtil;

@Controller
@RequestMapping("/notify")
public class OrderContorller {
	@Resource
	OrderUtil orderUtil;
	@Resource
	NotifyUtil notifyUtil;
	/**
	 * <p>后台调用的修订状态修改方法</p>
	 * @param OrderId		订单号
	 */
	@PostMapping("/notifyOrder")	
	@Transactional
	public void notifyOrder(String OrderId) {
		
	}

}
