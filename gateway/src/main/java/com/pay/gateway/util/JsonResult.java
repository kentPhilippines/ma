package com.pay.gateway.util;
/**
 * <p>异步请求返回类</p>
 * @author K
 * @date 2019-07-31
 */
public class JsonResult {
	private boolean success; // 请求操作是否成功
	private String message; // 提示信息
	private Object result; // 要传递到前端的结果
	/**
	 * <p>返回结果为成功,无返回提示,无结果集</p>
	 * <li>boolean success : true // 请求操作成功</li>
	 * <li>String  message : null // 提示消息null</li>
	 * <li>Object  result  : null // 返回结果集null</li>
	 * @return
	 */
	public static JsonResult buildSuccessResult() {
		return new JsonResult(true, null, null);
	}
	/**
	 * <p>返回结果为成功,返回提示,无结果集</p>
	 * <li>boolean success : true // 请求操作成功</li>
	 * <li>String  message : message // 提示消息message</li>
	 * <li>Object  result  : null // 返回结果集null</li>
	 * @param message	提示消息message
	 * @return
	 */
	public static JsonResult buildSuccessMessage(String message) {
		return new JsonResult(true, message, null);
	}
	/**
	 * <p>返回结果为成功,无返回提示,结果集</p>
	 * <li>boolean success : true // 请求操作成功</li>
	 * <li>String  message : null // 提示消息null</li>
	 * <li>Object  result  : result // 返回结果集result</li>
	 * @param result 返回结果集result
	 * @return
	 */
	public static JsonResult buildSuccessResult(Object result) {
		return new JsonResult(true, null, result);
	}
	/**
	 * <p>返回结果为成功,无返回提示,无结果集</p>
	 * <li>boolean success : true // 请求操作成功</li>
	 * <li>String  message : message // 提示消息message</li>
	 * <li>Object  result  : result // 返回结果集result</li>
	 * @param message	提示消息message
	 * @param result	返回结果集result
	 * @return
	 */
	public static JsonResult buildSuccessResult(String message, Object result) {
		return new JsonResult(true, message, result);
	}
	/**
	 * <p>返回结果为失败,无返回提示,无结果集</p>
	 * <li>boolean success : false // 请求操作成功</li>
	 * <li>String  message : null // 提示消息null</li>
	 * <li>Object  result  : null // 返回结果集null</li>
	 * @return
	 */
	public static JsonResult buildFailResult() {
		return new JsonResult(false, null, null);
	}
	/**
	 * <p>返回结果为失败,无返回提示,无结果集</p>
	 * <li>boolean success : false // 请求操作成功</li>
	 * <li>String  message : message // 提示消息message</li>
	 * <li>Object  result  : null // 返回结果集null</li>
	 * @param message	提示消息message
	 * @return
	 */
	public static JsonResult buildFailResult(String message) {
		return new JsonResult(false, message, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public JsonResult(boolean success, String message, Object result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}
	public JsonResult() {
		super();
	}
}
