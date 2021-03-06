/**
 * 
 */
package org.aposoft.wechat.company.managemnt.agent.remote;


import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.aposoft.wechat.company.managemnt.agent.AgentListResp;
import org.aposoft.wechat.company.managemnt.agent.AgentResp;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;

/**
 * 企业应用管理
 * 
 * @author Jann Liu
 *
 */
public class AgentClient implements QuietCloseable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String COMPANY_AGENT_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=";
	//
	static final String COMPANY_AGENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=";
	static final String COMPANY_AGENTID_URL = "&agentid=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 读取agent的信息
	 * 
	 * @param accessToken
	 * 
	 * @param agentid
	 *            企业应用id
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public AgentResp send(final String accessToken, final String agentid) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, agentid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.get(getAgentUrl(accessToken, agentid)), AgentResp.class, httpClient);
	}

	public AgentListResp send(final String accessToken) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.get(getAgentListUrl(accessToken)), AgentListResp.class, httpClient);
	}

	private String getAgentListUrl(String accessToken) {
		return COMPANY_AGENT_LIST_URL + accessToken;
	}

	private String getAgentUrl(String accessToken, String agentid) {
		return COMPANY_AGENT_URL + accessToken;
	}

}
