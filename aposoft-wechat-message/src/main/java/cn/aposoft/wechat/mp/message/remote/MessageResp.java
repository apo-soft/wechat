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
	private String type;
	private Long msgid;
	private Long msg_data_id;

	/**
	 * @return the msgid
	 */
	public Long getMsgid() {
		return msgid;
	}

	/**
	 * @param msgid
	 *            the msgid to set
	 */
	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	/**
	 * @return the msg_data_id
	 */
	public Long getMsg_data_id() {
		return msg_data_id;
	}

	/**
	 * @param msg_data_id
	 *            the msg_data_id to set
	 */
	public void setMsg_data_id(Long msg_data_id) {
		this.msg_data_id = msg_data_id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
