/**
 * 
 */
package cn.aposoft.wechat.company.auth;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 账号转换相应
 * 
 * @author Jann Liu
 *
 */
public class AccountExchangeResp extends WechatResp {
	private static final long serialVersionUID = 7331281808507645780L;
	//
	// {
	// "errcode": 0,
	// "errmsg": "ok",
	// "openid": "oDOGms-6yCnGrRovBj2yHij5JL6E",
	// "appid":"wxf874e15f78cc84a7"
	// }
	private String openid;
	private String appid;

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid
	 *            the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

}
