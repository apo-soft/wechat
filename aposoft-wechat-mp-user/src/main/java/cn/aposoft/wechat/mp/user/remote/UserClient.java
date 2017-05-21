/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClientFactory;

/**
 * 用户管理
 * 
 * @author liuya
 *
 */
public class UserClient {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String LIST_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

	static final String LIST_USER_URL_NEXT_OPENID = "&next_openid=";

}
