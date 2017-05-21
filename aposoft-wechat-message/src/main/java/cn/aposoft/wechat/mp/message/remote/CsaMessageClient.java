/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.remote.WechatResp;

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

		final String requestUrl = getCsaMessageUrl(accessToken);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(msg))//
				.build());
		String respMsg = HttpClient.execute(httpPost, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	private String getCsaMessageUrl(String accessToken) {
		return CSA_MESSAGE_URL + accessToken;
	}

}
