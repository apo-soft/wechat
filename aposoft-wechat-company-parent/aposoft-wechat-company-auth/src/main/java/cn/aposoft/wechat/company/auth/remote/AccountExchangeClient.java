/**
 * 
 */
package cn.aposoft.wechat.company.auth.remote;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.company.auth.AccountExchangeResp;

/**
 * @author Jann Liu
 *
 */
public class AccountExchangeClient implements QuietCloseable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	//
	static final String COMPANY_USERID_EXCHANGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=";
	static final String COMPANY_OPENID_EXCHANGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 发送报文
	 * 
	 * 
	 * @param accessToken
	 * @param userId
	 *            企业用户ID
	 * @param agentid
	 *            企业应用id
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public AccountExchangeResp send(final String accessToken, final String userId, final int agentid)
			throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, userId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		JSONObject jobj = new JSONObject().fluentPut("userid", userId).fluentPut("agentid", agentid);

		return HttpClient.execute(HttpClient.jsonPost(getCompanyUseridExchangeUrl(accessToken), jobj),
				AccountExchangeResp.class, httpClient);
	}

	/**
	 * 发送报文
	 * 
	 * @param accessToken
	 * @param userId
	 *            企业用户ID
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public AccountExchangeResp send(final String accessToken, final String userId) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, userId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		JSONObject jobj = new JSONObject().fluentPut("userid", userId);

		return HttpClient.execute(HttpClient.jsonPost(getCompanyUseridExchangeUrl(accessToken), jobj),
				AccountExchangeResp.class, httpClient);
	}

	public AccountExchangeResp sendOpenid(String accessToken, String openid) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, openid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		JSONObject jobj = new JSONObject().fluentPut("openid", openid);

		return HttpClient.execute(HttpClient.jsonPost(getCompanyOpenidExchangeUrl(accessToken), jobj),
				AccountExchangeResp.class, httpClient);
	}

	private String getCompanyOpenidExchangeUrl(String accessToken) {
		return COMPANY_OPENID_EXCHANGE_URL + accessToken;
	}

	// 发送消息
	private String getCompanyUseridExchangeUrl(String accessToken) {
		return COMPANY_USERID_EXCHANGE_URL + accessToken;
	}

}
