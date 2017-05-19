/**
 * 
 */
package cn.aposoft.wechat.mp.message.impl;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.message.IndustryConfigService;
import cn.aposoft.wechat.mp.message.remote.IndustryConfigClient;

/**
 * 行业信息查询
 * 
 * @author Jian Liu
 *
 */
public class AposoftIndustryConfigService implements IndustryConfigService {
	private IndustryConfigClient client = new IndustryConfigClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.message.IndustryConfigService#setIndustry(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void setIndustry(String accessToken, String industryId1, String industryId2) throws RemoteException {
		client.setIndustryConfig(accessToken, industryId1, industryId2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.message.IndustryConfigService#getIndustry(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public String getIndustry(String accessToken) throws RemoteException {
		return client.getIndustry(accessToken);
	}

	@Override
	public void close() {
		client.close();
	}

}
