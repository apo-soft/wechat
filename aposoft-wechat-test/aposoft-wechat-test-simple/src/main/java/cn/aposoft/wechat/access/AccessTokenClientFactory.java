/**
 * 
 */
package cn.aposoft.wechat.access;

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
