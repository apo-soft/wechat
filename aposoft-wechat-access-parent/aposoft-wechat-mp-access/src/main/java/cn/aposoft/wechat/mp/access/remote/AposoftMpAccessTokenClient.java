package cn.aposoft.wechat.mp.access.remote;

import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.access.remote.DefaultAccessTokenClient;

/**
 * 原始的AccessToken 微信公众号客户端
 * 
 * @author Jann Liu
 * @since 1.0
 * @deprecated use {@code DefaultAccessTokenClient} instead
 */
public class AposoftMpAccessTokenClient extends DefaultAccessTokenClient implements AccessTokenClient {

	/*
	 * (non-javadoc) 微信ACCESS_TOKEN读取URL
	 * 
	 * {@link
	 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&
	 * lang=zh_CN}
	 */
	// public static final String ACCESS_TOKEN_URL =
	// "https://api.weixin.qq.com/cgi-bin/token?";
	/**
	 * 默认构造函数
	 * 
	 * @see DefaultAccessTokenClient
	 */
	public AposoftMpAccessTokenClient() {

	}

	/**
	 * 构造函数,带用户访问地址配置信息
	 * 
	 * @param addressConfig
	 *            访问配置项
	 */
	public AposoftMpAccessTokenClient(AddressConfig addressConfig) {
		super(addressConfig);
	}

}
