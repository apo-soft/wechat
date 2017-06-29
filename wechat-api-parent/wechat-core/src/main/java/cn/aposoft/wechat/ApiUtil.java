/**
 * 
 */
package cn.aposoft.wechat;

/**
 * 返回值标准化工具类
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class ApiUtil {
	public static <T> ApiResult<T> success(T data) {
		return new BasicApiResult<T>(ApiResult.SUCCESS, ApiResult.SUCCESS_MESSAGE, data);
	}

	public static <T> ApiResult<T> fail() {
		return new BasicApiResult<T>(ApiResult.ERROR, ApiResult.ERROR_MESSAGE);
	}

	public static <T> ApiResult<T> illegalRequestParams() {
		return new BasicApiResult<T>(ApiResult.ILLEGAL_REQUEST_PARAM_ERROR,
				ApiResult.ILLEGAL_REQUEST_PARAM_ERROR_MESSAGE);
	}
}
