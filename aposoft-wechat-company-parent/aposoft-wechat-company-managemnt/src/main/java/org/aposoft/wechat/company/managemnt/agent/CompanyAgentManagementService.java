package org.aposoft.wechat.company.managemnt.agent;

import cn.aposoft.io.QuietCloseable;
import cn.aposoft.wechat.RemoteException;

/**
 * 企业应用管理
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAgentManagementService extends QuietCloseable {

	AgentResp getAgent(final String accessToken, final String agentid) throws RemoteException;

	AgentListResp getAgentList(final String accessToken) throws RemoteException;

	@Override
	public void close();
}
