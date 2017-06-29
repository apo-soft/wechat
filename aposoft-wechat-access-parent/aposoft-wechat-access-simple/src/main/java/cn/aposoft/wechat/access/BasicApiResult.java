/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * @author Jann Liu
 *
 */
public class BasicApiResult<T> implements ApiResult<T> {
	private static final long serialVersionUID = -1138006667336726348L;
	private String code;
	private String message;
	private T data;

	public BasicApiResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BasicApiResult(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public T getData() {
		return data;
	}

}
