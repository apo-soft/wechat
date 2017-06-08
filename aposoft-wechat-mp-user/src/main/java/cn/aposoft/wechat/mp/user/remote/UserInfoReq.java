package cn.aposoft.wechat.mp.user.remote;

import java.io.Serializable;

import cn.aposoft.constant.WechatLang;

/**
 * 用户信息请求
 * 
 * @author Jann Liu
 *
 */
public class UserInfoReq implements Serializable {
	private static final long serialVersionUID = -5012773236915902266L;
	private String openid;
	private String lang;

	/**
	 * 初始化请求信息
	 * 
	 * @param openid
	 *            用户OPEN_ID
	 * @param lang
	 *            语言
	 */
	public UserInfoReq(String openid) {
		this(openid, WechatLang.zh_CN.name());
	}

	/**
	 * 初始化请求信息
	 * 
	 * @param openid
	 *            用户OPEN_ID
	 * @param lang
	 *            语言
	 */
	public UserInfoReq(String openid, String lang) {
		this.openid = openid;
		this.lang = lang;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
