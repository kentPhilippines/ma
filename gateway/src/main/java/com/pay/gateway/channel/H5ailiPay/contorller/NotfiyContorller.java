package com.pay.gateway.channel.H5ailiPay.contorller;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pay.gateway.channel.H5ailiPay.util.BankUtil;
import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.exception.OtherErrors;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.DealOrder;
import com.pay.gateway.service.AccountService;
import com.pay.gateway.service.OrderService;
import com.pay.gateway.service.RunningOrderService;
import com.pay.gateway.util.JsonResult;
import com.pay.gateway.util.NotifyUtil;
import com.pay.gateway.util.OrderUtil;

import cn.hutool.core.util.StrUtil;

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
	@PostMapping("/payH5")
	@Transactional
	@ResponseBody
	 public JsonResult payH5OrderEnter(String bankPhone,String amount,HttpServletRequest request){
		 log.info("=============【进入转卡交易回调处理类】============");
		 /**
		  * 如果金额是100.1 或者是  100.20  等
		  * 就会被转换为      100    10       100     20
		  */
		 String[] split = amount.split("\\.");
		 String startAmount = split[0];
		 String endAmount = split[1];
		 
		 int length = endAmount.length();
		 if(length == 1) {//当交易金额为整小数的时候        补充0
			 endAmount += endAmount+"0";
		 }
		 amount = startAmount + "." + endAmount;//得到正确的金额
		 log.info("=============【当前回调金额："+amount+"】============");
		 /**
		  * <li>1,查找交易订单</li>
		  * <li>2,查找交易银行卡</li>
		  * <li>3,修改交易订单状态</li>
		  * <li>4,修改交易账户相关金额</li>
		  * <li>5,生成交易流水</li>
		  * <li>6,删除缓存相关交易信息</li>
		  */
		log.info("【收到回调服务短信回调通知】");
		String money = request.getParameter("amount");
		String deviceid = request.getParameter("bankPhone");
		log.info("【获取金额为："+money+"】");
		log.info("【获取物理介质唯一标识为："+deviceid+"】");
		String key = deviceid + money;
		log.info("【组合当前唯一KEY为："+key+"】");
		String orderIdAll = bankUtil.findOrderBankCard(new BigDecimal(amount),bankPhone);//获取全局订单	根据全局订单查询  交易订单
		if(StrUtil.isBlank(orderIdAll)) {
			log.info("【匹配的全局订单失效】");
			return JsonResult.buildFailResult("全局订单失效",0);
		}
		log.info("=============【获得全局订单编号，开始修改交易订单状态并生成流水，全局订单编号："+orderIdAll+"】============");
		boolean flag = orderUtil.updataOrderStatus(orderIdAll);//修改訂單狀態並生成對應的流水
		//發給下游通知回調
		notifyUtil.sendMsg(orderIdAll, flag);
		if(!flag)//回滚所有数据
			throw new OtherErrors("交易回调发生异常");
		String message = "回调成功";
		String result =  orderIdAll;
		return JsonResult.buildSuccessResult(message, result);
	 }
}
