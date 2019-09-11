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
	 * <p>是否开通交易</p>
	 */
	public static final Integer IS_DEAL_NO = 1;//1启用2停用3自动切换
	public static final Integer IS_DEAL_OFF = 0;//1启用2停用3自动切换
	public static final Integer IS_DPAY_OFF = 0;//1启用2停用3自动切换
	public static final Integer IS_DPAY_NO = 0;//1启用2停用3自动切换
	
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
	/**
	 * <p>收款卡</p>
	 */
	public static final Integer BANKCARDTYPE_DEAL =0;//收款卡
	/**
	 * <p>中轉卡</p>
	 */
	public static final Integer BANKCARDTYPE_TRANSFER = 1;//中轉卡
	/**
	 * <p>出款卡</p>
	 */
	public static final Integer BANKCARDTYPE_WIT = 2;//出款卡
	/**
	 * <p>凍結卡</p>
	 */
	public static final Integer BANKCARDTYPE_FREEZR = 3;//冻结卡
	/**
	 * <p>測試卡</p>
	 */
	public static final Integer BANKCARDTYPE_TEST = 4;//測試卡
	
	
	
	/**
	 * <p>全局订单类型</p>
	 * 订单类型:1交易,5代付
	 */
	/**
	 * <p>交易類型全局訂單</p>
	 */
	public static final Integer BANKORDERALL_DEAL = 1;//交易
	/**
	 * <p>代付類型全局訂單</p>
	 */
	public static final Integer BANKORDERALL_WIT = 5;//代付
	
	/**
	 * <p>凍結類型</p>
	 */
	/**
	 * <p>資金凍結類型 D1</p>
	 */
	public static final String FREEZE_D1 = "D1";//D1類型凍結  工作日情況下到下一日日切時間后結算
	/**
	 * <p>資金凍結類型 T1</p>
	 */
	public static final String FREEZE_T1 = "T1";//T1類型凍結 非工作情況下  到下一日工作日日切時間結算凍結資金
	/**
	 * <p>流水訂單處理狀態</p>
	 * <p>自然處理</p>
	 */
	public static final Integer RUN_STATUS_1 = 1;//1自然處理
	/**
	 * <p>流水訂單處理狀態</p>
	 * <p>人工處理</p>
	 */
	public static final Integer RUN_STATUS_2 = 2;//2人工處理
	/**
	 * <p>流水訂單類型</p>
	 */
	public static final Integer RUN_TYPE_DEAL = 1;//交易
	public static final Integer RUN_SYSTEM_ADD_MONEY = 2;//系統加錢
	public static final Integer RUN_DEAL_FEE = 3;//交易手續費
	public static final Integer RUN_SYSTEM_DELETE_MONEY = 4;//系統減款
	public static final Integer RUN_WITHDRAWALS_PAY = 5;//代付
	public static final Integer RUN_WITHDRAWALS_PAY_FEE = 6;//代付手續費
	public static final Integer RUN_FREEZE = 7;//凍結
	public static final Integer RUN_UN_FREEZE = 8;//解凍
	/**
	 * <p>工作日</p>
	 */
	public static final Integer DAY_ALL_WORK = 0;//工作日
	/**
	 * <p>非工作日</p>
	 */
	public static final Integer DAY_ALL_NOTWORK = 1;//非工作日
	
	
	
	
	
	
	
	public static final String COD_15034 = "15034";//必传参数为空
	public static final String MSG_15034 = "必传参数为空";//必传参数为空
	public static final String COD_14006 = "14006";//必传参数为空
	public static final String MSG_14006 = "外部商户订单号重复";//必传参数为空
	public static final String COD_14001 = "14001";//必传参数为空
	public static final String MSG_14001 = "当前交易额度超过该账号最大交易额度";//必传参数为空
	public static final String COD_14002 = "14002";//必传参数为空
	public static final String MSG_14002 = "当前交易额度小于该账号最小交易额度";//必传参数为空
	public static final String COD_14003 = "14003";//必传参数为空
	public static final String MSG_14003 = "当日交易累计已超过该账号最大交易额度";//必传参数为空
	public static final String COD_15001 = "15001";//必传参数为空
	public static final String MSG_15001 = "当前商户账户费率未配置或费率状态未开通";//必传参数为空
	public static final String COD_14005 = "14005";//必传参数为空
	public static final String MSG_14005 = "全局订单生成异常";//必传参数为空
	public static final String COD_14004 = "14004";//必传参数为空
	public static final String MSG_14004 = "交易失败";//必传参数为空
	public static final String COD_15030 = "15030";//必传参数为空
	public static final String MSG_15030 = "字符编码未设置";//必传参数为空
	public static final String COD_15031 = "15031";//必传参数为空
	public static final String MSG_15031 = "字符编码错误，请设置为UTF-8";//必传参数为空
	public static final String COD_15020 = "15020";//必传参数为空
	public static final String MSG_15020 = "用户不存在";//必传参数为空
	public static final String COD_15033 = "15033";//必传参数为空
	public static final String MSG_15033 = "请求过期";//必传参数为空
	public static final String COD_15032 = "15032";//必传参数为空
	public static final String MSG_15032 = "时间格式错误";//必传参数为空
	public static final String COD_15010 = "15010";//必传参数为空
	public static final String MSG_15010 = "验签失败";//必传参数为空
	public static final String COD_15002 = "15002";//必传参数为空
	public static final String MSG_15002 = "用户未开通交易服务";//必传参数为空
	/**
	 * <p>银行卡流水分类</p>
	 */
	public static final Integer BANKCARD_RUN_DEAL = 1;//商户交易
	public static final Integer BANKCARD_RUN_BENEFIT = 3;//账户入款分润
	public static final Integer BANKCARD_RUN_DPAY = 2;//卡商回款
	
	
	
	
	/**
	 * <p>缓存里面银行卡唯一标识+金额的位数切割</p>
	 */
	public static final Integer BANKCARD_AMOUNT_BUMBER = 12;//
	
}
