/**
 * 
 */
package cn.aposoft.wechat.mp.server.remote;

import java.io.Closeable;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.RemoteException;

/**
 * 读取服务器IP客户端
 * 
 * @author Jann Liu
 *
 */
public class ServerIpClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	final static String IP_CALLBACK_URP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	public ServerIpResp getIpList(String accessToken) throws RemoteException {
		final String requestUrl = getServerIpUrl(accessToken);
		HttpGet httpGet = new HttpGet(requestUrl);
		return HttpClient.execute(httpGet, ServerIpResp.class, httpClient);
	}

	private String getServerIpUrl(String accessToken) {
		return IP_CALLBACK_URP + accessToken;
	}

}
