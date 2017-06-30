/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user.impl;

import java.util.List;

import org.aposoft.wechat.company.managemnt.user.User;
import org.aposoft.wechat.company.managemnt.user.UserListResp;
import org.aposoft.wechat.company.managemnt.user.UserManagementService;
import org.aposoft.wechat.company.managemnt.user.UserResp;
import org.aposoft.wechat.company.managemnt.user.remote.UserManagementClient;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.WechatResult;

/**
 * 用户管理服务
 * 
 * @author Jann Liu
 *
 */
public class AposoftUserManagementService implements UserManagementService {
	final UserManagementClient client = new UserManagementClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#create(
	 * java.lang.String,
	 * org.aposoft.wechat.company.managemnt.agent.AgentResp.User)
	 */
	@Override
	public WechatResp create(final String accessToken, final User user) throws RemoteException {
		return client.create(accessToken, user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#update(
	 * java.lang.String,
	 * org.aposoft.wechat.company.managemnt.agent.AgentResp.User)
	 */
	@Override
	public WechatResp update(String accessToken, User user) throws RemoteException {
		return client.update(accessToken, user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#delete(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public WechatResp delete(String accessToken, String userid) throws RemoteException {
		return client.delete(accessToken, userid);
	}

	@Override
	public WechatResult delete(String accessToken, List<String> userid) throws RemoteException {
		return client.delete(accessToken, userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#get(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public UserResp get(String accessToken, String userid) throws RemoteException {
		return client.get(accessToken, userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aposoft.wechat.company.managemnt.user.UserManagementService#get(
	 * String accessToken, int departmentId, int fetchChild, int status)
	 */
	@Override
	public UserListResp get(String accessToken, int departmentId, int fetchChild, int status) throws RemoteException {
		return client.get(accessToken, departmentId, fetchChild, status);
	}

	@Override
	public UserListResp getDetail(String accessToken, int departmentId, int fetchChild, int status)
			throws RemoteException {
		return client.getDetail(accessToken, departmentId, fetchChild, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aposoft.wechat.company.managemnt.user.UserManagementService#close()
	 */
	@Override
	public void close() {
		client.close();
	}

}
