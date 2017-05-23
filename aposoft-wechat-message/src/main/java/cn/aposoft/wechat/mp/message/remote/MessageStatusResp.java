/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

/**
 * @author Jann Liu
 *
 */
public class MessageStatusResp {

	public static final String SEND_SUCCESS = "SEND_SUCCESS";

	private String msg_id;
	private String msg_status;

	/**
	 * @return the msg_id
	 */
	public String getMsg_id() {
		return msg_id;
	}

	/**
	 * @param msg_id
	 *            the msg_id to set
	 */
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	/**
	 * @return the msg_status
	 */
	public String getMsg_status() {
		return msg_status;
	}

	/**
	 * @param msg_status
	 *            the msg_status to set
	 */
	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}
}
