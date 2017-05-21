/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.message.TemplateMessage;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 发送模板消息
 * 
 * @author Jann Liu
 *
 */
public class TemplateMessageClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	// 读取模板列表URL
	static final String TEMPLATE_LIST_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=";

	final static String SEND_TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	private String getTemplateListUrl(final String accessToken) {
		return TEMPLATE_LIST_URL + accessToken;
	}

	/**
	 * 读取模板列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 模板列表JSON
	 * @throws RemoteException
	 */
	public String getTemplateList(final String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createHttpGet(getTemplateListUrl(accessToken)), String.class);
	}

	/**
	 * 上传客服头像
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param account
	 *            客服账户信息
	 * @param image
	 *            头像信息
	 * @return 响应结果
	 * @throws RemoteException
	 */
	public MessageResp sendTemplateMessage(final String accessToken, final TemplateMessage msg) throws RemoteException {
		if (StringUtil.isBlank(accessToken, msg)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createJsonHttpPost(getSendTemplateMessageUrl(accessToken), msg), MessageResp.class);
	}

	private HttpPost createJsonHttpPost(final String requestUrl, final Object entity) {
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(entity))//
				.build());
		return httpPost;
	}

	private HttpGet createHttpGet(String listUrl) {
		return new HttpGet(listUrl);
	}

	// 内部请求公共类
	private WechatResp execute(final HttpUriRequest httpRequest) throws RemoteException {
		return execute(httpRequest, WechatResp.class);
	}

	@SuppressWarnings("unchecked")
	private <T> T execute(HttpUriRequest httpRequest, Class<T> clazz) throws RemoteException {
		String respMsg = HttpClient.execute(httpRequest, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		if (clazz == String.class) {
			// unchecked
			return (T) respMsg;
		}
		return JSON.parseObject(respMsg, clazz);
	}

	private String getSendTemplateMessageUrl(String accessToken) {
		return SEND_TEMPLATE_MESSAGE_URL + accessToken;
	}
}
