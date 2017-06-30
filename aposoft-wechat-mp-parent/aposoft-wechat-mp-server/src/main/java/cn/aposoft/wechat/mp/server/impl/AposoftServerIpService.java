/**
 * 
 */
package cn.aposoft.wechat.mp.server.impl;

import java.util.Collections;
import java.util.List;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.mp.server.ServerIpService;
import cn.aposoft.wechat.mp.server.remote.ServerIpClient;
import cn.aposoft.wechat.mp.server.remote.ServerIpResp;

/**
 * @author Jann Liu
 *
 */
public class AposoftServerIpService implements ServerIpService {
	private ServerIpClient serverClient = new ServerIpClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.server.ServerService#getIpList(java.lang.String)
	 */
	@Override
	public List<String> getIpList(String accessToken) throws RemoteException {

		ServerIpResp resp = serverClient.getIpList(accessToken);
		if (resp != null) {
			return resp.getIp_list();
		}
		return Collections.emptyList();
	}

	@Override
	public void close() {
		serverClient.close();
	}

}
