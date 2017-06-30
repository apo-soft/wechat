/**
 * 
 */
package cn.aposoft.wechat.access;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.access.AccessTokenClient;
import cn.aposoft.wechat.access.AccessTokenResp;
import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.access.address.AddressUtil;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * 默认微信服务访问授权码请求客户端
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DefaultAccessTokenClient implements AccessTokenClient {
	//
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	private volatile AddressConfig addressConfig;

	/**
	 * 默认Client实现,需要调用{@code setAddressConfig}进行初始化
	 */
	public DefaultAccessTokenClient() {

	}

	public DefaultAccessTokenClient(AddressConfig addressConfig) {
		this.addressConfig = addressConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.access.remote.AccessTokenClient#setAddressConfig(cn.
	 * aposoft.wechat.access.address.AddressConfig)
	 */
	@Override
	public void setAddressConfig(AddressConfig addressConfig) {
		this.addressConfig = addressConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.remote.AccessTokenClient#getAccessToken(cn.
	 * aposoft.wechat.access.AccessTokenConfig)
	 */
	@Override
	public AccessTokenResp getAccessToken(AccountConfig accessTokenReq) throws RemoteException {
		final String requestUrl = getAccessTokenUrl(accessTokenReq);
		HttpGet httpGet = new HttpGet(requestUrl);
		return HttpClient.execute(httpGet, AccessTokenResp.class, httpClient);
	}

	// 封装对AccessToken的动态拼接
	// https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
	private String getAccessTokenUrl(AccountConfig accessTokenReq) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(AddressUtil
				.getParamConfig("access_token_access_id", accessTokenReq.getAccountType(), addressConfig).getName(),
				accessTokenReq.getId()));
		params.add(new BasicNameValuePair(AddressUtil
				.getParamConfig("access_token_access_secret", accessTokenReq.getAccountType(), addressConfig).getName(),
				accessTokenReq.getSecret()));
		String paramsUrl = URLEncodedUtils.format(params, StandardCharsets.UTF_8);
		final String requestUrl = addressConfig.getUrlConfig(accessTokenReq.getAccountType()).getUrl() + paramsUrl;
		return requestUrl;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
