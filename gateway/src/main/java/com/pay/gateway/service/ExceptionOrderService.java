package com.pay.gateway.service;

import com.pay.gateway.entity.ExceptionOrderEntity;

public interface ExceptionOrderService {

	/**
	 * <p>添加异常订单</p>
	 * @param exceopt
	 * @return
	 */
	boolean addExceptionOrder(ExceptionOrderEntity exceopt);

}
