/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.wechat.WechatResp;

/**
 * 
 * 用户关注后二次验证请求
 * 
 * @author Jann Liu
 *
 */
public class UserAuthsuccClient implements Closeable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	//
	static final String COMPANY_USER_AUTHSUCC_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=";
	static final String COMPANY_USERID_PARAM_URL = "&userid=";

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
	public WechatResp send(final String accessToken, final String userid) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, userid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.executeWechat(HttpClient.get(getUserAuthsuccUrl(accessToken, userid)), httpClient);
	}

	private String getUserAuthsuccUrl(String accessToken, String userid) {
		return COMPANY_USER_AUTHSUCC_URL + accessToken + COMPANY_USERID_PARAM_URL + userid;
	}
}
