/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClientFactory;

/**
 * 群发消息客户端
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	
	
	
	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
