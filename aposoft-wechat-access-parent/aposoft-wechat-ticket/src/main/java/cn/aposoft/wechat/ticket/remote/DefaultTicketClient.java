/**
 * 
 */
package cn.aposoft.wechat.ticket.remote;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.ticket.Ticket.Type;

/**
 * 默认Ticket客户端
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DefaultTicketClient implements TicketClient {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	public DefaultTicketClient() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.ticket.remote.TicketClient#getTicket(java.lang.String,
	 * cn.aposoft.wechat.ticket.Ticket.Type)
	 */
	@Override
	public TicketResp getTicket(String accessToken, Type type) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, type)) {
			throw new IllegalArgumentException();
		}
		String url = getUrl(accessToken, type);
		return HttpClient.execute(HttpClient.get(url), TicketResp.class, httpClient);
	}

	private String getUrl(String accessToken, Type type) {
		return type.url + accessToken;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
