package com.pay.gateway.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pay.gateway.entity.DealOrder;
/**
 * #################################################
 * 當前所有的自然交易流水生產和自然代付流水生成都會是2筆，一筆為金額一筆為手續費
 * #################################################
 * @author K
 */
public interface RunningOrderService {
	/**
	 * <p>根據交易訂單信息創建交易流水</p>
	 * @param dealOrder			交易訂單信息
	 * @param runType 
	 * @return
	 */
	boolean createDealRun(DealOrder dealOrder, Integer runStatus);
	/**
	 * <p>根據交易訂單創建手續費流水</p>
	 * @param dealOrder			交易訂單信息
	 * @param runType 
	 * @return
	 */
	boolean createDealRunFee(DealOrder dealOrder, Integer runStatus);

}
