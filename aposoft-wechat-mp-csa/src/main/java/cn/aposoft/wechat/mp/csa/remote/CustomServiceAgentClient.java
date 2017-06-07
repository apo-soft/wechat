/**
 * 
 */
package cn.aposoft.wechat.mp.csa.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.csa.AgentAccount;

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
		return HttpClient.executeWechat(HttpClient.jsonPost(getAddUrl(accessToken), account), httpClient);
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
		return HttpClient.executeWechat(HttpClient.jsonPost(getUpdateUrl(accessToken), account), httpClient);
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
		return HttpClient.executeWechat(HttpClient.jsonPost(getDeleteUrl(accessToken), account), httpClient);
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
		return HttpClient.executeWechat(HttpClient.jsonPost(getDeleteUrl(accessToken), account), httpClient);
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
		return HttpClient.execute(HttpClient.get(getListUrl(accessToken)), KfListAccountResp.class,
				httpClient);
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

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
