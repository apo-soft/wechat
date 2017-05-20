/**
 * 
 */
package org.aposoft.wechat.mp.csa.impl;

import java.util.List;

import org.aposoft.wechat.mp.csa.AgentAccount;
import org.aposoft.wechat.mp.csa.CustomServiceAgentService;
import org.aposoft.wechat.mp.csa.remote.CustomServiceAgentClient;
import org.aposoft.wechat.mp.csa.remote.KfListAccountResp;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 
 * 客服管理模块
 * 
 * @author liuya
 *
 */
public class DefaultCustomServiceAgentService implements CustomServiceAgentService {
	final CustomServiceAgentClient client = new CustomServiceAgentClient();

	/**
	 * 新增客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @throws RemoteException
	 */
	public WechatResp add(String accessToken, AgentAccount account) throws RemoteException {
		return client.add(accessToken, account);
	}

	/**
	 * 更新客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @throws RemoteException
	 */
	public WechatResp update(String accessToken, AgentAccount account) throws RemoteException {
		return client.update(accessToken, account);
	}

	/**
	 * 刪除客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @throws RemoteException
	 */
	public WechatResp delete(String accessToken, AgentAccount account) throws RemoteException {
		return client.delete(accessToken, account);
	}

	@Override
	public WechatResp uploadHeadImg(String accessToken, AgentAccount account, byte[] image) throws RemoteException {
		return client.uploadHeadImg(accessToken, account, image);
	}

	/**
	 * 读取客服列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 客服列表
	 */
	public List<AgentAccount> getAgentList(String accessToken) throws RemoteException {
		KfListAccountResp resp = client.list(accessToken);
		if (resp == null) {
			throw new RemoteException("No resp found.");
		}
		return resp.getKf_list();
	}

	@Override
	public void close() {
		client.close();
	}

}
