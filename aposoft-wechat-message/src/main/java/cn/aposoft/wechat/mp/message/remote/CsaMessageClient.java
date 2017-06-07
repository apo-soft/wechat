/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;

/**
 * 客服消息发送方法
 * 
 * @author Jann Liu
 *
 */
public class CsaMessageClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	//
	static final String CSA_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	public WechatResp send(final String accessToken, final String msg) throws RemoteException {
		if (StringUtil.isBlank(accessToken, msg)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.executeWechat(HttpClient.jsonPost(getCsaMessageUrl(accessToken), msg), httpClient);
	}

	private String getCsaMessageUrl(String accessToken) {
		return CSA_MESSAGE_URL + accessToken;
	}

}
