/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import cn.aposoft.wechat.mp.remote.WechatResponse;

/**
 * 用户响应
 * 
 * @author Jann Liu
 *
 */
public class UserResp extends User implements WechatResponse {
	private static final long serialVersionUID = -8083162090434469258L;
	private Integer errcode;
	private String errmsg;

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public Integer getErrcode() {
		return errcode;
	}

	@Override
	public String getErrmsg() {
		return errmsg;
	}
}
