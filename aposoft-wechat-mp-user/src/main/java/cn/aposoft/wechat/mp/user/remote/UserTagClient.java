/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.Closeable;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * @author Jann Liu
 *
 */
public class UserTagClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String USER_LEBEL_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";

	static final String USER_LEBEL_LIST_URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=";

	/**
	 * 添加标签，重复提交相同标签，返回45157错误
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return {"tag":{"id":101,"name":"亲属"}}
	 *         <p>
	 *         {"errcode":45157,"errmsg":"invalid tag name hint:
	 *         [rwL31a0162vr23]"}
	 * @throws RemoteException
	 */
	public WechatResp create(String accessToken, String name) throws RemoteException {
		if (StringUtil.isBlank(accessToken, name)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		String url = getLabelCreateUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);

		JSONObject jobj = new JSONObject().fluentPut("tag", //
				new JSONObject().fluentPut("name", name));
		String jsonString = jobj.toJSONString();
		System.out.println(jsonString);
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(jsonString).build());

		String respMsg = HttpClient.execute(httpPost, httpClient);
		System.out.println(respMsg);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	/**
	 * 添加标签，重复提交相同标签，返回45157错误
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return {"tag":{"id":101,"name":"亲属"}}
	 *         <p>
	 *         {"errcode":45157,"errmsg":"invalid tag name hint:
	 *         [rwL31a0162vr23]"}
	 * @throws RemoteException
	 */
	public WechatResp list(String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		String url = getLabelListUrl(accessToken);
		HttpGet httpGet = new HttpGet(url);

		String respMsg = HttpClient.execute(httpGet, httpClient);
		System.out.println(respMsg);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	// 创建访问Url
	private String getLabelListUrl(String accessToken) {
		return USER_LEBEL_LIST_URL + accessToken;
	}

	// 创建访问Url
	private String getLabelCreateUrl(String accessToken) {
		return USER_LEBEL_CREATE_URL + accessToken;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
