/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.company.common;

import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AccessTokenResp;

/**
 * 企业 Access Token 客户端
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class CompanyAccessTokenClient implements AccessTokenClient, Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	/**
	 * 微信ACCESS_TOKEN读取URL
	 * 
	 * {@link http://qydev.weixin.qq.com/wiki/index.php?title=%E4%B8%BB%E5%8A%A8%E8%B0%83%E7%94%A8}
	 */
	public static final String COMPANY_ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?";

	/**
	 * 向微信服务器请求，返回的AccessToken响应结果 客户端不区分微信服务器返回的结果内容是否存在错误,对错误的处理需要在服务层实现
	 * 
	 * @param accessTokenReq
	 * @return 微信服务器返回的AccessToken响应结果
	 * 
	 *         <pre>
	 * 			{
	 * 				"access_token":"d_uqUS_Abt-TcKDpuZj-FLkWOe54nrvZbBKuJwXN2d9Qk67OMQHuwZ9MAFRN2plB",
	 * 				"expires_in":7200
	 * 			}
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	@Override
	public AccessTokenResp getAccessToken(AccessTokenConfig config) throws RemoteException {
		final String requestUrl = getAccessTokenUrl(config);
		HttpGet httpGet = new HttpGet(requestUrl);
		return HttpClient.execute(httpGet, AccessTokenResp.class, httpClient);
	}

	// 封装对AccessToken的动态拼接
	// https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
	private String getAccessTokenUrl(AccessTokenConfig accessTokenReq) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("corpid", accessTokenReq.getId()));
		params.add(new BasicNameValuePair("corpsecret", accessTokenReq.getSecret()));
		String paramsUrl = URLEncodedUtils.format(params, StandardCharsets.UTF_8);
		final String requestUrl = COMPANY_ACCESS_TOKEN_URL + paramsUrl;
		return requestUrl;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
