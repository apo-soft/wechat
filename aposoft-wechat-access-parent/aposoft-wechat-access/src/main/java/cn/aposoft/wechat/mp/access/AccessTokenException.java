/**
 * 
 */
package cn.aposoft.wechat.mp.access;

import cn.aposoft.util.RemoteException;

/**
 * 读取AccessToken的异常
 * 
 * @author Jann Liu
 *
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
