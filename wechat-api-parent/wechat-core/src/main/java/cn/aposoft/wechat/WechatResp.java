/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat;

import java.io.Serializable;

/**
 * 微信用户验证基础响应消息
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class WechatResp implements WechatResult, Serializable {
	private static final long serialVersionUID = -5375917048488103386L;
	private Integer errcode;
	private String errmsg;

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	@Override
	public String toString() {
		if (errcode == null) {
			return "";
		} else {
			return "[" + errcode + "]" + errmsg;
		}
	}
}
