/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;

/**
 * 消息管理客户端
 * 
 * @author Jann Liu
 *
 */
public class MessageManagementClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	static final String AUTO_REPLY_RULE_URL = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	public AutoReplyRuleResp getAutoReplyRule(final String accessToken) throws RemoteException {
		return HttpClient.execute(HttpClient.get(getAutoReplyRulUrl(accessToken)), AutoReplyRuleResp.class,
				httpClient);
		//
	}

	private String getAutoReplyRulUrl(final String accessToken) {
		return AUTO_REPLY_RULE_URL + accessToken;
	}
}
