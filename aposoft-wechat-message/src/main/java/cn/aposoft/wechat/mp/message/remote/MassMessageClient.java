/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;
import java.util.Map;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.message.MsgType;

/**
 * 群发消息客户端
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String MASS_SENDALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 发送微信新闻
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param filter
	 *            过滤器
	 * @param media
	 *            素材
	 * @param configs
	 *            配置项
	 * @return 消息发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendMpnews(final String accessToken, final Filter filter, final MediaIdHolder media,
			Map<String, Object> configs) throws RemoteException {
		return send(accessToken, filter, MsgType.mpnews, media, configs);
	}

	// 群发消息基础方法
	protected MessageResp send(final String accessToken, final Filter filter, MsgType msgType, final Object media,
			Map<String, Object> configs) throws RemoteException {
		JSONObject jobj = new JSONObject().fluentPut("filter", filter).fluentPut("msgtype", msgType.name())
				.fluentPut(msgType.name(), media).fluentPutAll(configs);
		return HttpClient.execute(HttpClient.createJsonHttpPost(getMassSendUrl(accessToken), jobj), MessageResp.class,
				httpClient);
	}

	private String getMassSendUrl(String accessToken) {
		return MASS_SENDALL_URL+accessToken;
	}
}
