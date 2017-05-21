/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.config.WechatLang;

/**
 * 用户管理
 * 
 * @author Jann Liu
 *
 */
public class UserClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String LIST_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

	static final String LIST_USER_URL_NEXT_OPENID = "&next_openid=";

	static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

	static final String USER_INFO_URL_OPENID = "&openid=";

	static final String USER_INFO_URL_LANG = "&lang=";

	static final String USER_INFO_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";

	/**
	 * 读取默认用户列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @return 用户列表响应
	 * @throws RemoteException
	 */
	public UserResp getUser(String accessToken) throws RemoteException {
		return getUser(accessToken, null);
	}

	/**
	 * 读取默认用户列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param nextOpenId
	 *            请求起始open_id
	 * @return 用户列表响应
	 * @throws RemoteException
	 */
	public UserResp getUser(String accessToken, String nextOpenId) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		String url = getListUserUrl(accessToken, nextOpenId);
		HttpGet httpGet = new HttpGet(url);
		String respMsg = HttpClient.execute(httpGet, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserResp.class);
	}

	/**
	 * 读取默认用户列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param nextOpenId
	 *            请求起始open_id
	 * @return 用户个人信息
	 * @throws RemoteException
	 */
	public UserInfoResp getUserInfo(String accessToken, String openId) throws RemoteException {
		return getUserInfo(accessToken, openId, WechatLang.zh_CN.name());
	}

	/**
	 * 读取默认用户列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param nextOpenId
	 *            请求起始open_id
	 * @return 用户列表响应
	 * @throws RemoteException
	 */
	public UserInfoResp getUserInfo(String accessToken, String openId, String lang) throws RemoteException {
		if (StringUtil.isBlank(accessToken, openId, lang)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		if (WechatLang.valueOf(lang) == null) {
			lang = WechatLang.zh_CN.name();
		}
		String url = getUserInfoUrl(accessToken, openId, lang);
		HttpGet httpGet = new HttpGet(url);
		String respMsg = HttpClient.execute(httpGet, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserInfoResp.class);
	}

	/**
	 * 读取默认用户列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param nextOpenId
	 *            请求起始open_id
	 * @return 用户列表响应
	 * @throws RemoteException
	 */
	public UserInfoListResp getUserInfoList(String accessToken, List<UserInfoReq> useInfoList) throws RemoteException {
		if (StringUtil.isBlank(accessToken, useInfoList)) {
			throw new IllegalArgumentException("access_token is empty.");
		}

		String url = getListUserInfoUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity = buildEntity(useInfoList);
		httpPost.setEntity(entity);
		String respMsg = HttpClient.execute(httpPost, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserInfoListResp.class);
	}

	private HttpEntity buildEntity(List<UserInfoReq> useInfoList) {
		Map<String, Object> userList = new HashMap<>();
		userList.put("user_list", useInfoList);
		return EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(userList)).build();
	}

	private String getListUserInfoUrl(String accessToken) {
		return USER_INFO_LIST_URL + accessToken;
	}

	private String getUserInfoUrl(String accessToken, String openId, String lang) {
		return USER_INFO_URL + accessToken + USER_INFO_URL_OPENID + openId + USER_INFO_URL_LANG + lang;
	}

	private String getListUserUrl(String accessToken, String nextOpenId) {
		return LIST_USER_URL + accessToken
				+ (StringUtil.isBlank(nextOpenId) ? "" : LIST_USER_URL_NEXT_OPENID + nextOpenId);
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
