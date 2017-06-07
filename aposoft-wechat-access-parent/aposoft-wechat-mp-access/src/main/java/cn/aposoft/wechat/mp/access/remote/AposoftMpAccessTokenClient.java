package cn.aposoft.wechat.mp.access.remote;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cn.aposoft.constant.Lexical;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenConfig;

public class AposoftMpAccessTokenClient implements AccessTokenClient {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	/**
	 * 微信ACCESS_TOKEN读取URL
	 * 
	 * {@link https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN}
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";

	/**
	 * 向微信服务器请求，返回的AccessToken响应结果 客户端不区分微信服务器返回的结果内容是否存在错误,对错误的处理需要在服务层实现
	 * 
	 * @param accessTokenReq
	 * @return 微信服务器返回的AccessToken响应结果
	 * @throws RemoteException
	 */
	public AccessTokenResp getAccessToken(AccessTokenConfig accessTokenReq) throws RemoteException {
		final String requestUrl = getAccessTokenUrl(accessTokenReq);
		HttpGet httpGet = new HttpGet(requestUrl);
		return HttpClient.execute(httpGet, AccessTokenResp.class, httpClient);

	}

	// 封装对AccessToken的动态拼接
	// https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN
	private String getAccessTokenUrl(AccessTokenConfig accessTokenReq) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("grant_type", "client_credential"));
		params.add(new BasicNameValuePair("appid", accessTokenReq.getId()));
		params.add(new BasicNameValuePair("secret", accessTokenReq.getSecret()));
		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = ACCESS_TOKEN_URL + paramsUrl;
		return requestUrl;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
