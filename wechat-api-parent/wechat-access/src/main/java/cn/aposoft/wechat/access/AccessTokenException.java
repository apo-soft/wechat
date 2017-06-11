/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.RemoteException;

/**
 * 读取AccessToken的异常
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AccessTokenException extends RemoteException {
	public AccessTokenException(String message, RemoteException e) {
		super(message, e);
	}

	public AccessTokenException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 4568824713778938484L;

}