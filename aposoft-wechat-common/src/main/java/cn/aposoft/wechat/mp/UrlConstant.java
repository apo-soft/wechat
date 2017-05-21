/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp;

/**
 * ACCESS_TOKEN + OAUTH2 的URL访问地址
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class UrlConstant {
	private UrlConstant() {
	}

	/**
	 * 微信ACCESS_TOKEN读取URL
	 * 
	 * {@link https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN}
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";

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
	public static final String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";

	/**
	 * OAUTH2 第三步：刷新access_token（如果需要）
	 * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 */
	public static final String OAUTH2_REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";

	/**
	 * OAUTH2 第四步：拉取用户信息(需scope为 snsapi_userinfo)
	 * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 */
	public static final String OAUTH2_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?";

	/**
	 * OAUTH2 附：检验授权凭证（access_token）是否有效
	 * https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
	 */
	public static final String OAUTH2_AUTH = "https://api.weixin.qq.com/sns/auth?";

}
