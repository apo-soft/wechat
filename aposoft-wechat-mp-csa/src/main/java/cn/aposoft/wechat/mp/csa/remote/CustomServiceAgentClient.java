/**
 * 
 */
package cn.aposoft.wechat.mp.csa.remote;

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
import cn.aposoft.wechat.mp.csa.AgentAccount;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 客服人员配置客户端
 * 
 * @author Jian Liu
 *
 */
public class CustomServiceAgentClient implements Closeable {
	private final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	// 新增客服信息
	final static String KFACCOUNT_ADD_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
	// 更新客服信息
	final static String KFACCOUNT_UPDATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
	// 删除客服信息
	final static String KFACCOUNT_DELETE_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=";
	// 上传头像的URL
	final static String KFACCOUNT_HEAD_IMG_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=%s&kf_account=%s";
	// 读取客服列表
	final static String KFACCOUNT_LIST_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";

	/**
	 * 添加客服账号
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param account
	 *            客服账户信息
	 * @return 响应结果
	 * @throws RemoteException
	 */
	public WechatResp add(final String accessToken, final AgentAccount account) throws RemoteException {
		if (StringUtil.isBlank(accessToken, account, account.getAccount(), account.getNickname(),
				account.getPassword())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createJsonHttpPost(getAddUrl(accessToken), account));
	}

	/**
	 * 更新客服账号
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param account
	 *            客服账户信息
	 * @return 响应结果
	 * @throws RemoteException
	 */
	public WechatResp update(final String accessToken, final AgentAccount account) throws RemoteException {
		if (StringUtil.isBlank(accessToken, account, account.getAccount(), account.getNickname(),
				account.getPassword())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createJsonHttpPost(getUpdateUrl(accessToken), account));
	}

	/**
	 * 删除客服账号
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param account
	 *            客服账户信息
	 * @return 响应结果
	 * @throws RemoteException
	 */
	public WechatResp delete(final String accessToken, final AgentAccount account) throws RemoteException {
		if (StringUtil.isBlank(accessToken, account, account.getAccount())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createJsonHttpPost(getDeleteUrl(accessToken), account));
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
	public WechatResp uploadHeadImg(final String accessToken, final AgentAccount account, byte[] image)
			throws RemoteException {
		if (StringUtil.isBlank(accessToken, account, account.getAccount())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createJsonHttpPost(getDeleteUrl(accessToken), account));
	}

	/**
	 * 客服列表
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param account
	 *            客服账户信息
	 * @return 响应结果
	 * @throws RemoteException
	 */
	public KfListAccountResp list(final String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return execute(createHttpGet(getListUrl(accessToken)), KfListAccountResp.class);
	}

	private HttpGet createHttpGet(String listUrl) {
		return new HttpGet(listUrl);
	}

	private String getListUrl(String accessToken) {
		return KFACCOUNT_LIST_URL + accessToken;
	}

	private String getAddUrl(String accessToken) {
		return KFACCOUNT_ADD_URL + accessToken;
	}

	private String getUpdateUrl(String accessToken) {
		return KFACCOUNT_UPDATE_URL + accessToken;
	}

	private String getDeleteUrl(String accessToken) {
		return KFACCOUNT_DELETE_URL + accessToken;
	}

	private HttpPost createJsonHttpPost(final String requestUrl, final Object entity) {
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(entity))//
				.build());
		return httpPost;
	}

	// 内部请求公共类
	private WechatResp execute(final HttpUriRequest httpRequest) throws RemoteException {
		return execute(httpRequest, WechatResp.class);
	}

	private <T> T execute(HttpUriRequest httpRequest, Class<T> clazz) throws RemoteException {
		String respMsg = HttpClient.execute(httpRequest, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		System.out.println(respMsg);
		return JSON.parseObject(respMsg, clazz);
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
