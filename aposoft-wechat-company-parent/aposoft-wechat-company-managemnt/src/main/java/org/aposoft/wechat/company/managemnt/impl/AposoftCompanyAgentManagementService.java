/**
 * 
 */
package org.aposoft.wechat.company.managemnt.impl;

import org.aposoft.wechat.company.managemnt.AgentListResp;
import org.aposoft.wechat.company.managemnt.AgentResp;
import org.aposoft.wechat.company.managemnt.CompanyAgentManagementService;
import org.aposoft.wechat.company.managemnt.remote.AgentClient;

import cn.aposoft.util.RemoteException;

/**
 * 企业应用管理服务实现
 * 
 * @author Jann Liu
 *
 */
public class AposoftCompanyAgentManagementService implements CompanyAgentManagementService {
	final AgentClient client = new AgentClient();

	@Override
	public AgentResp getAgent(String accessToken, String agentid) throws RemoteException {
		return client.send(accessToken, agentid);
	}

	@Override
	public AgentListResp getAgentList(String accessToken) throws RemoteException {
		return client.send(accessToken);
	}

	@Override
	public void close() {
		client.close();
	}

}
