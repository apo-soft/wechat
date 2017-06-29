/**
 * 
 */
package cn.aposoft.wechat;

/**
 * 基础对外访问结果封装对象
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicApiResult<T> implements ApiResult<T> {
	private static final long serialVersionUID = -1138006667336726348L;
	private int code;
	private String msg;
	private T data;

	public BasicApiResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BasicApiResult(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public T getData() {
		return data;
	}

}
