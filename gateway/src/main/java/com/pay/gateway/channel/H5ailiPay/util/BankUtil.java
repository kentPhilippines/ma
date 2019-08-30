package com.pay.gateway.channel.H5ailiPay.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pay.gateway.config.common.Common;
import com.pay.gateway.config.redis.RedisUtil;
import com.pay.gateway.entity.BankCard;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>项目银行卡管理</p>
 * @author K
 */
@Service(value = "BankUtil")
public class BankUtil {
	
	 @Autowired
	 RedisUtil redisUtil;
     private static BankUtil bankUtil;
     //初始化 ②
     @PostConstruct 
     public void init() {      
    	 bankUtil = this;
    	 bankUtil.redisUtil = this.redisUtil;
      }
	/**
	 * <p>通过关键数据确认收款银行卡</p>
	 * @param bankList			所有目前可以使用的银行卡
	 * @param amount			当前交易金额
	 * @param bankPhone			银行卡绑定的手机号
	 * @return
	 */
	public BankCard findDealBankCard(List<BankCard> bankList,BigDecimal amount , String orderNo) {
		/**
		 * <p>银行卡选择逻辑</p>
		 * <li>1,优先选择目前可以使用的</li>
		 * <li>2.1如果没有银行卡可以使用则选择 5分钟之内 不会出现相同订单金额的银行卡</li>
		 * <li>2.2 每张银行卡 交前都会存入缓存</li>
		 * <li>2.3 再次选择的的时候通过金额和过期时间判断银行卡是否可以使用</li>
		 * 同一个银行卡和金额只要在缓存里面存在的话就不会被选择作为  收款的银行卡
		 */
		Collections.shuffle(bankList); // 随机排列
		Map<String,List> map = new HashMap<String,List>();
		List<String> listk = new ArrayList();
		for(BankCard bank : bankList) {
			List<Object> bankListuse =  bankUtil.redisUtil.lGet(bank.getBankPhone(),0,-1);//获取当前该银行卡下所有的正在使用的银行卡的配置情况
			if(CollUtil.isEmpty(bankListuse)) {
				//存入缓存并返回可以使用的银行卡
				 bankUtil.redisUtil.set(bank.getBankPhone()+amount.toString(),orderNo,240);//4分钟过期时间
				listk.add(bank.getBankPhone()+amount.toString());
				 bankUtil.redisUtil.lSet(bank.getBankPhone(), listk);
				bank.setDealAmount(amount);
				return bank;
			}
			//如果发现没有银行卡可以使用则获取所有的银行卡正在使用的银行卡
			map.put(bank.getBankPhone(), bankListuse);
		}
		/**
		 * ######获取目前正在使用的所有银行卡他们在5分钟内使用的次数(list集合长度就是银行卡5分钟使用的次数)的最小次数######使用这张卡
		 */
		int size = 0;
		String keys = null; //计算之后这个值就是我要替换的数据key 也就是银行卡
		for(String key : map.keySet()) {//获取最大个数
			//选择最少的使用次数
			List<Object> list = map.get(key);
			if(list.size() > size) {
				size = list.size();
				keys = key;
			};
		}
		for(String key : map.keySet()) {
			List<Object> list = map.get(key);
			if(list.size() < size) {
				size = list.size();
				keys = key;
			};
		}
		/**
		 * ######获取目前正在使用的所有银行卡他们在5分钟内使用的次数(list集合长度就是银行卡5分钟使用的次数)的最小次数######使用这张卡
		 */
		/**
		 * ##这里有可能发生下标越界
		 */
		List<Object> listKeys = map.get(keys);//获取这个银行卡的使用记录key
		for(Object bankKey: listKeys) {//bankKey 就是具体的银行卡使用记录的  key
			Object object =  bankUtil.redisUtil.get(bankKey.toString());
			if(ObjectUtil.isNull(object)) {//说明当前缓存内的银行卡使用记录 已过期
				  Iterator<Object> it = listKeys.iterator();
			        while(it.hasNext()){
			            String str = (String)it.next();
			            if(object.equals(str)){
			                it.remove();
			            }        
			        }
			}
		}
		 bankUtil.redisUtil.deleteKey(keys);//删除Key 以及数据
		 bankUtil.redisUtil.lSet(keys,listKeys);//跟新数据
		//现在集合里面的就是目前该银行卡所有的正在使用的记录
		List amountList = new ArrayList();
		String phoneK = null;
		for(Object k: listKeys) {
			phoneK = StrUtil.subPre(k.toString(),11);//理论上是电话号码-且都是一样的数据
			String amountK = StrUtil.subSuf(k.toString(),12);//金额
			amountList.add(new BigDecimal(amountK));
		}
		BigDecimal amount2 = getAmount(amountList,amount);//得到钱数
		 bankUtil.redisUtil.set(phoneK+amount2.toString(),orderNo,240);//4分钟过期时间
		for(BankCard bankCardR : bankList) {
			if(bankCardR.getBankPhone().equals(phoneK)) {
				bankCardR.setDealAmount(amount2);
				return bankCardR;
			}
		}
		return null;
	}
	
	/**
	 * <p>获取银行卡和金额所对应的订单</p>
	 * @param bankList	 所有在缓存中的银行卡   目前这个金额和卡片是包括订单号的
	 * @param amount	卡池回调金额	
	 * @param bankPhone	银行卡绑定手机号
	 * @return
	 */
	public String findOrderBankCard(List<BankCard> bankList,BigDecimal amount , String bankPhone) {
		String key = bankPhone + amount.toString() ;
		String orderId = (String) bankUtil.redisUtil.get(key);
		 bankUtil.redisUtil.del(key);
		return orderId;
	}
	private BigDecimal getAmount(List amountList ,BigDecimal  amount) {
		if(amountList.contains(amount)) {//出现金额相同的情况的时候  生成不一样的金额
			amount.add(new BigDecimal("0.01"));//递增的钱数
			return getAmount(amountList,amount);
		}
		return amount;
	}
	public BigDecimal findDealAmount(BigDecimal amount ) {
		List<Object> amountList =  bankUtil.redisUtil.lGet("Amount",0,-1);
		if(CollUtil.isNotEmpty(amountList)) {
			if(amountList.contains(amount.toString())) {
				amount = amount.add(new BigDecimal("0.01"));//递增的钱数
				return findDealAmount(amount);
			}
			amountList.add(amount.toString());
			 bankUtil.redisUtil.deleteKey("Amount");//删除Key 以及数据
			 bankUtil.redisUtil.lSet("Amount",amountList);//跟新数据
		}
		return amount;
	}
	
	
	

}
