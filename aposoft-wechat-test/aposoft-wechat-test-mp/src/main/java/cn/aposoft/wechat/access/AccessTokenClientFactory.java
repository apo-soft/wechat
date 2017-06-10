/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.access.remote.DefaultAccessTokenClient;

/**
 * 授权码客户端工厂
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AccessTokenClientFactory {

	public static AccessTokenClient getAccessTokenClient() {
		AccessTokenClient accessTokenClient = new DefaultAccessTokenClient();
		accessTokenClient.setAddressConfig(AddressConfigFactory.getMpAddressConfig());
		return accessTokenClient;
	}

	public static AccessTokenClient getCompanyAccessTokenClient() {
		AccessTokenClient accessTokenClient = new DefaultAccessTokenClient();
		accessTokenClient.setAddressConfig(AddressConfigFactory.getCompanyAddressConfig());
		return accessTokenClient;
	}
}
