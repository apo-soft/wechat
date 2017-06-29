/**
 * 
 */
package cn.aposoft.wechat;

import java.io.Serializable;

/**
 * Rest返回接口
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface ApiResult<T> extends Serializable {
	public static final int SUCCESS = 0;
	public static final String SUCCESS_MESSAGE = "OK";
	public static final int ERROR = -1;
	public static final String ERROR_MESSAGE = "ERROR";

	public static final int ILLEGAL_REQUEST_PARAM_ERROR = -2;
	public static final String ILLEGAL_REQUEST_PARAM_ERROR_MESSAGE = "ILLEGAL_REQUEST_PARAM_ERROR";

	int getCode();

	String getMsg();

	T getData();
}
