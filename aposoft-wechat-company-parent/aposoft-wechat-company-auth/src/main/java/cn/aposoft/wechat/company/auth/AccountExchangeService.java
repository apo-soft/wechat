/**
 * 
 */
package cn.aposoft.wechat.company.auth;

import java.io.Closeable;

import cn.aposoft.util.RemoteException;

/**
 * 账户转换服务
 * 
 * @author Jann Liu
 *
 */
public interface AccountExchangeService extends Closeable {
	/**
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param userId
	 *            企业用户ID
	 * @param agentId
	 *            应用ID
	 * @return 应用对应的openID
	 * @throws RemoteException
	 */
	AccountExchangeResp convertToOpenId(String accessToken, String userId, int agentId) throws RemoteException;

	/**
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param userId
	 *            企业用户ID
	 * @return 对应的openID
	 * @throws RemoteException
	 */
	AccountExchangeResp convertToOpenId(String accessToken, String userId) throws RemoteException;

	@Override
	public void close();
}
