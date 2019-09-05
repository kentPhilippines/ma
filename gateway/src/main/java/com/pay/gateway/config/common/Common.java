package com.pay.gateway.config.common;

public final class Common {
	public static final String CODING = "UTF-8";//账户未登录错误
	public static final String DATATYPE = "yyyyMMddHHmmss";//账户未登录错误
	
	
	/**
	 * <p>费率状态</p>
	 */
	public static final Integer FEE_STATUS1 = 1;//1启用2停用3自动切换
	public static final Integer FEE_STATUS2 = 2;//1启用2停用3自动切换
	public static final Integer FEE_STATUS3 = 3;//1启用2停用3自动切换
	
	
	
	/**
	 * 交易返回信息Key 
	 */
	public static final String RESULTDEAL = "resultDeal";//账户未登录错误
	
	
	
	
	/**
	 * <p>订单生成表头</p>
	 */
	public static final String ORDERDEAL = "DE";//交易订单
	public static final String ORDERRUN = "RUN";//流水订单
	public static final String ORDERWIT = "WIT";//代付订单
	public static final String ORDERALL = "ALL";//所有订单
	
	
	
	
	
	
	/**
	 *	<p>交易订单类型</p>
	 */
	public static final Integer ORDERDEALTYP_DEAL = 1;//交易订单
	public static final Integer ORDERDEALTYPE_SYSTEM = 2;//系统加款
	/**
	 * <p>交易订单状态</p>
	 */
	public static final Integer ORDERDEASTATUS_T = 1;//交易订单 处理中
	public static final Integer ORDERDEASTATUS_SU = 2;//交易订单 成功
	public static final Integer ORDERDEASTATUS_ER = 3;//交易订单 失败
	
	
	/**
	 * <p>响应状态码</p>
	 */
	public static final String RESPONSE_STATUS_SU = "00";//成功
	public static final String RESPONSE_STATUS_SU_MSG = "成功";//成功
	public static final String RESPONSE_STATUS_ER = "11";//失败
	public static final String RESPONSE_STATUS_ER_MSG = "失败";//成功
	
	
	/**
	 * <p>银行卡类别</p>
	 * 银行类别0收款卡,1中转卡,2出款卡,3冻结卡,4测试卡 
	 */
	public static final Integer BANKCARDTYPE_DEAL = 1;//收款卡
	public static final Integer BANKCARDTYPE_WIT = 2;//收款卡
	public static final Integer BANKCARDTYPE_FREEZR = 3;//冻结卡
	public static final Integer BANKCARDTYPE_TEST = 4;//收款卡
	
	
	
	/**
	 * <p>全局订单类型</p>
	 * 订单类型:1交易,5代付
	 */
	public static final Integer BANKORDERALL_DEAL = 1;//收款卡
	public static final Integer BANKORDERALL_WIT = 5;//收款卡
	
	/**
	 * <p>凍結類型</p>
	 */
	public static final String FREEZE_D1 = "D1";//D1類型凍結  工作日情況下到下一日日切時間后結算
	public static final String FREEZE_T1 = "T1";//T1類型凍結 非工作情況下  到下一日工作日日切時間結算凍結資金
	
	

}
