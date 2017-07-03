/**
 * 
 */
package cn.aposoft.wechat.company.message.remote;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;

/**
 * 企业消息
 * 
 * @author Jann Liu
 *
 */
public class CompanyMessgeClient implements QuietCloseable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	//
	static final String COMPANY_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 发送报文
	 * 
	 * @param accessToken
	 * @param msg
	 *            报文内容
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp send(final String accessToken, final String msg) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, msg)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.jsonPost(getCompanyMessageUrl(accessToken), msg), MessageResp.class,
				httpClient);
	}

	// 发送消息
	private String getCompanyMessageUrl(String accessToken) {
		return COMPANY_MESSAGE_URL + accessToken;
	}
}
