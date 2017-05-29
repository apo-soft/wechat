package org.aposoft.wechat.company.managemnt.agent;

import java.io.Closeable;

import cn.aposoft.util.RemoteException;

/**
 * 企业应用管理
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAgentManagementService extends Closeable {

	AgentResp getAgent(final String accessToken, final String agentid) throws RemoteException;

	AgentListResp getAgentList(final String accessToken) throws RemoteException;

	@Override
	public void close();
}
