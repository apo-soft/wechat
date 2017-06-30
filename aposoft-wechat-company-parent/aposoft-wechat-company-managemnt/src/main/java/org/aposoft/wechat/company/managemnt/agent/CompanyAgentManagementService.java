package org.aposoft.wechat.company.managemnt.agent;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;

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
