/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth.impl;

import cn.aposoft.wechat.mp.auth.WechatAuthorizeService;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenClient;
import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class WechatAuthorizeServiceFactory {
	// 是否初始化
	private static boolean init;
	private static WechatAuthorizeService service;

	public static boolean isInit() {
		return init;
	}

	public static void setClient(Oauth2AccessTokenClient client, WechatMpConfig config) {
		service = new BasicWechatAuthorizeService(client, config);
		init = true;
	}

	/**
	 * @return 读取微信授权访问服务，读取前必须确认Factory已经初始化
	 */
	public static WechatAuthorizeService getService() {
		return service;
	}
}
