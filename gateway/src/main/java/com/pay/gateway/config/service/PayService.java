package com.pay.gateway.config.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.pay.gateway.config.entity.PayOrder;
import com.pay.gateway.entity.Account;
import com.pay.gateway.entity.AccountFee;
import com.pay.gateway.entity.OrderAll;
import com.pay.gateway.entity.dealEntity.Deal;
import com.pay.gateway.entity.dealEntity.ResultDeal;

public interface PayService {
    
	/**
	 * <p>支付交易</p>
	 * @param deal
	 * @param accountFee 
	 * @param account 
	 * @param orderAll 
	 * @return
	 */
	ResultDeal deal(Deal deal, Account account, AccountFee accountFee, OrderAll orderAll);
}
