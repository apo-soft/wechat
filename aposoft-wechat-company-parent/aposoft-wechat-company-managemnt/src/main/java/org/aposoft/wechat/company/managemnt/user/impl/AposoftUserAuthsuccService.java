/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user.impl;

import org.aposoft.wechat.company.managemnt.user.UserAuthsuccService;
import org.aposoft.wechat.company.managemnt.user.remote.UserAuthsuccClient;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * @author Jann Liu
 *
 */
public class AposoftUserAuthsuccService implements UserAuthsuccService {
	final UserAuthsuccClient client = new UserAuthsuccClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#authsucc(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public WechatResp authsucc(String accessToken, String userid) throws RemoteException {
		return client.send(accessToken, userid);
	}

	@Override
	public void close() {
		client.close();
	}

}
