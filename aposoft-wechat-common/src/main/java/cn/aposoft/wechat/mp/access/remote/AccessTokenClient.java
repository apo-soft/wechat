/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access.remote;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;

import cn.aposoft.constant.Lexical;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.UrlConstant;
import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * Access Token 客户端
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class AccessTokenClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	/**
	 * 向微信服务器请求，返回的AccessToken响应结果 客户端不区分微信服务器返回的结果内容是否存在错误,对错误的处理需要在服务层实现
	 * 
	 * @param accessTokenReq
	 * @return 微信服务器返回的AccessToken响应结果
	 * @throws RemoteException
	 */
	public AccessTokenResp getAccessToken(WechatMpConfig accessTokenReq) throws RemoteException {
		final String requestUrl = getAccessTokenUrl(accessTokenReq);
		HttpGet httpGet = new HttpGet(requestUrl);

		String respMsg = HttpClient.execute(httpGet, httpClient);
		if (!StringUtils.isBlank(respMsg)) {
			AccessTokenResp resp = JSON.parseObject(respMsg, AccessTokenResp.class);
			return resp;
		} else {
			throw new RemoteException("empty response message.");
		}
	}

	// 封装对AccessToken的动态拼接
	// https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN
	private String getAccessTokenUrl(WechatMpConfig accessTokenReq) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("grant_type", "client_credential"));
		params.add(new BasicNameValuePair("appid", accessTokenReq.getAppId()));
		params.add(new BasicNameValuePair("secret", accessTokenReq.getAppSecret()));
		String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
		final String requestUrl = UrlConstant.ACCESS_TOKEN_URL + paramsUrl;
		return requestUrl;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
