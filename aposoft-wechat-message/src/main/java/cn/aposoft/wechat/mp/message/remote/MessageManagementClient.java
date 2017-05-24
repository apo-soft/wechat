/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

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

	/**
	 * 读取自动回复消息配置，当启用服务器调用时，自动禁用消息自动回复
	 * 
	 * @param accessToken
	 *            {@see AccessToken} 访问授权码
	 * @return {"is_add_friend_reply_open":1,"is_autoreply_open":1}
	 * @throws RemoteException
	 */
	public AutoReplyRuleResp getAutoReplyRule(final String accessToken) throws RemoteException {
		return HttpClient.execute(HttpClient.get(getAutoReplyRulUrl(accessToken)), AutoReplyRuleResp.class, httpClient);
		//
	}

	private String getAutoReplyRulUrl(final String accessToken) {
		return AUTO_REPLY_RULE_URL + accessToken;
	}
}
