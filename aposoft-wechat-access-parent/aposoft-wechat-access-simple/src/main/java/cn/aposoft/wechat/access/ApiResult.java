/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.Serializable;

/**
 * Rest返回接口
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface ApiResult<T> extends Serializable {
	public static final String SUCCESS = "0000";
	public static final String SUCCESS_MESSAGE = "OK";
	public static final String ERROR = "0001";
	public static final String ERROR_MESSAGE = "ERROR";

	public static final String ILLEGAL_REQUEST_PARAM_ERROR = "0002";
	public static final String ILLEGAL_REQUEST_PARAM_ERROR_MESSAGE = "ILLEGAL_REQUEST_PARAM_ERROR";

	String getCode();

	String getMessage();

	T getData();
}
