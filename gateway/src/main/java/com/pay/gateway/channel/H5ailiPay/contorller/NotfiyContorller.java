package com.pay.gateway.channel.H5ailiPay.contorller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pay.gateway.channel.H5ailiPay.util.BankUtil;
import com.pay.gateway.config.exception.OtherErrors;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.service.RunningOrderService;
import com.pay.gateway.util.NotifyUtil;
import com.pay.gateway.util.OrderUtil;

@Controller
@RequestMapping("/notfiy")
public class NotfiyContorller {
	@Resource
	BankUtil bankUtil;
	@Autowired
	OrderService orderServiceImpl;
	@Autowired
	RunningOrderService RunningOrderServiceImpl;
	Logger log = LoggerFactory.getLogger(NotfiyContorller.class);
	@Autowired
	AccountService accountServiceImpl;
	@Resource
	OrderUtil orderUtil;
	@Resource
	NotifyUtil notifyUtil;
	/**
	 * <p>银行卡数据回调</p>
	 * @param bankPhone			交易手机号
	 * @param amount			交易金额
	 * <p>该接口根据卡池的具体传参来决定参数</p>
	 */
	 @RequestMapping("/payH5")
	 @Transactional
	 public void payH5OrderEnter(@RequestParam("bankPhone")String bankPhone,@RequestParam("amount")String amount){
		 log.info("=============【進入轉卡支付交易回調處理類】============");
		 /**
		  * 如果金额是100.1 或者是  100.20  等
		  * 就会被转换为      100    10       100     20
		  */
		 String[] split = amount.split(".");
		 String startAmount = split[0];
		 String endAmount = split[1];
		 int length = endAmount.length();
		 if(length == 1) {//当交易金额为整小数的时候        补充0
			 endAmount += endAmount+"0";
		 }
		 amount = split + "." + endAmount;//得到正确的金额
		 log.info("=============【當前回調金額："+amount+"】============");
		 /**
		  * <li>1,查找交易订单</li>
		  * <li>2,查找交易银行卡</li>
		  * <li>3,修改交易订单状态</li>
		  * <li>4,修改交易账户相关金额</li>
		  * <li>5,生成交易流水</li>
		  * <li>6,删除缓存相关交易信息</li>
		  */
		 String orderIdAll = bankUtil.findOrderBankCard(new BigDecimal(amount),bankPhone);//获取全局订单	根据全局订单查询  交易订单
		 log.info("=============【獲得全局訂單編號，并開始修改交易訂單狀態，全局訂單編號："+orderIdAll+"】============");
		 boolean flag = orderUtil.updataOrderStatus(orderIdAll);//修改訂單狀態並生成對應的流水
		 //發給下游通知回調
		 notifyUtil.sendMsg(orderIdAll, flag);
		 if(!flag)
			 throw new OtherErrors("交易回調發成異常");
	 }
}
