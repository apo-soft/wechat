package cn.aposoft.wechat.mp.auth.remote;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cn.aposoft.constant.Lexical;
import cn.aposoft.constant.WechatLang;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.config.MpAccountConfig;

public class Oauth2AccessTokenClient implements Closeable {
	/**
	 * 
	 * 访问请求标准URL及参数
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
	 * OAUTH2 第一步：用户同意授权，获取code
	 * {@link http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html}
	 * 
	 */
	public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";

	/**
	 * OAUTH2 * 第二步：通过code换取网页授权access_token
	 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	 */
	static final String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";

	/**
	 * OAUTH2 第三步：刷新access_token（如果需要）
	 * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 */
	static final String OAUTH2_REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";

	/**
	 * OAUTH2 第四步：拉取用户信息(需scope为 snsapi_userinfo)
	 * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 */
	static final String OAUTH2_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?";

	/**
	 * OAUTH2 附：检验授权凭证（access_token）是否有效
	 * https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
	 */
	static final String OAUTH2_AUTH = "https://api.weixin.qq.com/sns/auth?";
	private static final Oauth2AccessTokenClient client = new Oauth2AccessTokenClient();

	public static Oauth2AccessTokenClient getInstance() {
		return client;
	}

	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	public Oauth2AccessTokenResp getOauth2Token(String code, MpAccountConfig config) throws RemoteException {
		return HttpClient.execute(new HttpGet(getAccessTokenUrl(code, config)), Oauth2AccessTokenResp.class,
				httpClient);
	}

	/**
	 * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public Oauth2AccessTokenResp refreshAccessToken(String refreshToken, MpAccountConfig config) throws RemoteException {
		return HttpClient.execute(new HttpGet(getRefreshAccessTokenUrl(refreshToken, config)),
				Oauth2AccessTokenResp.class, httpClient);

	}

	/**
	 * 
	 * 读取用户信息(zh_CN)
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openId
	 *            用户的唯一标识
	 * 
	 * @return 用户个人信息
	 * @throws RemoteException
	 */
	public WechatUserInfoResp getUserInfo(String accessToken, String openId) throws RemoteException {
		return getUserInfo(accessToken, openId, WechatLang.zh_CN.name());
	}

	/**
	 * 读取用户信息
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openId
	 *            用户的唯一标识
	 * @param lang
	 *            返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return 用户个人信息
	 * @throws RemoteException
	 */
	public WechatUserInfoResp getUserInfo(String accessToken, String openId, String lang) throws RemoteException {
		return HttpClient.execute(new HttpGet(getUserInfoUrl(accessToken, openId, lang)), WechatUserInfoResp.class,
				httpClient);
	}

	/**
	 * 验证ACCESS_TOKEN是否有效
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openId
	 *            用户的唯一标识
	 * @return 验证结果
	 * @throws RemoteException
	 */
	public Oauth2AuthResp auth(String accessToken, String openId) throws RemoteException {
		final String requestUrl = getAuthUrl(accessToken, openId);
		HttpGet httpGet = new HttpGet(requestUrl);
		return HttpClient.execute(httpGet, Oauth2AuthResp.class, httpClient);

	}

	// 验证ACCESS_TOKEN是否有效的URL
	private String getAuthUrl(String accessToken, String openId) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("access_token", accessToken));
		params.add(new BasicNameValuePair("openid", openId));

		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = OAUTH2_AUTH + paramsUrl;
		return requestUrl;
	}

	private String getUserInfoUrl(String accessToken, String openId, String lang) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("access_token", accessToken));
		params.add(new BasicNameValuePair("openid", openId));
		params.add(new BasicNameValuePair("lang", lang));

		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = OAUTH2_USER_INFO_URL + paramsUrl;
		return requestUrl;
	}

	private String getAccessTokenUrl(String code, MpAccountConfig config) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("appid", config.getId()));
		params.add(new BasicNameValuePair("secret", config.getSecret()));
		params.add(new BasicNameValuePair("code", code));
		params.add(new BasicNameValuePair("grant_type", "authorization_code"));

		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = OAUTH2_ACCESS_TOKEN_URL + paramsUrl;
		return requestUrl;
	}

	private String getRefreshAccessTokenUrl(String refreshToken, MpAccountConfig config) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("appid", config.getId()));
		params.add(new BasicNameValuePair("grant_type", "refresh_token"));
		params.add(new BasicNameValuePair("refresh_token", refreshToken));

		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = OAUTH2_REFRESH_ACCESS_TOKEN_URL + paramsUrl;

		return requestUrl;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
