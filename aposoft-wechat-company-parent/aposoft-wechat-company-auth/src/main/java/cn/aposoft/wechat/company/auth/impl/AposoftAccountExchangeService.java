/**
 * 
 */
package cn.aposoft.wechat.company.auth.impl;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.auth.AccountExchangeResp;
import cn.aposoft.wechat.company.auth.AccountExchangeService;
import cn.aposoft.wechat.company.auth.remote.AccountExchangeClient;

/**
 * 账号转换服务
 * 
 * @author Jann Liu
 *
 */
public class AposoftAccountExchangeService implements AccountExchangeService {
	final AccountExchangeClient client = new AccountExchangeClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.auth.AccountExchangeService#convertToOpenId(
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public AccountExchangeResp convertToOpenId(String accessToken, String userId, int agentId) throws RemoteException {
		return client.send(accessToken, userId, agentId);
	}

	@Override
	public AccountExchangeResp convertToOpenId(String accessToken, String userId) throws RemoteException {
		return client.send(accessToken, userId);
	}

	@Override
	public void close() {
		client.close();
	}

}
