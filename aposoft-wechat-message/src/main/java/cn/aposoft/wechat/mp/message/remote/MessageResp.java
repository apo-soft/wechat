/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * @author Jann Liu
 *
 */
public class MessageResp extends WechatResp {
	private static final long serialVersionUID = -7381389205215266583L;
	private Integer msgid;

	/**
	 * @return the msgid
	 */
	public Integer getMsgid() {
		return msgid;
	}

	/**
	 * @param msgid
	 *            the msgid to set
	 */
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}
}
