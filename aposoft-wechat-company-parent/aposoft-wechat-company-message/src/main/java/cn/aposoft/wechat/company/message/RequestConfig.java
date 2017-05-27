/**
 * 
 */
package cn.aposoft.wechat.company.message;

import java.io.Serializable;

/**
 * 请求配置信息
 * 
 * @author Jann Liu
 * @version 1.0
 */
public class RequestConfig implements Serializable {
	private static final long serialVersionUID = 8122868387706699072L;
	// "touser": "UserID1|UserID2|UserID3",
	private String[] touser;
	// "toparty": " PartyID1 | PartyID2 ",
	private String[] toparty;
	// "totag": " TagID1 | TagID2 ",
	private String[] totag;
	// "msgtype": "text", 使用外部msgType，避免出错
	// private MsgType msgtype;
	// "agentid": 1,
	private Integer agentid;
	// "text": {
	// "content": "Holiday Request For Pony(http://xxxxx)"
	// },
	private Integer safe;
	// "safe":0

	/**
	 * @return the touser
	 */
	public String[] getTouser() {
		return touser;
	}

	/**
	 * @param touser
	 *            the touser to set
	 */
	public void setTouser(String[] touser) {
		this.touser = touser;
	}

	/**
	 * @return the toparty
	 */
	public String[] getToparty() {
		return toparty;
	}

	/**
	 * @param toparty
	 *            the toparty to set
	 */
	public void setToparty(String[] toparty) {
		this.toparty = toparty;
	}

	// /**
	// * @return the msgtype
	// */
	// public MsgType getMsgtype() {
	// return msgtype;
	// }
	//
	// /**
	// * @param msgtype
	// * the msgtype to set
	// */
	// public void setMsgtype(MsgType msgtype) {
	// this.msgtype = msgtype;
	// }

	/**
	 * @return the agentid
	 */
	public Integer getAgentid() {
		return agentid;
	}

	/**
	 * @param agentid
	 *            the agentid to set
	 */
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	/**
	 * @return the safe
	 */
	public Integer getSafe() {
		return safe;
	}

	/**
	 * @param safe
	 *            the safe to set
	 */
	public void setSafe(Integer safe) {
		this.safe = safe;
	}

	/**
	 * @return the totag
	 */
	public String[] getTotag() {
		return totag;
	}

	/**
	 * @param totag
	 *            the totag to set
	 */
	public void setTotag(String[] totag) {
		this.totag = totag;
	}

}
