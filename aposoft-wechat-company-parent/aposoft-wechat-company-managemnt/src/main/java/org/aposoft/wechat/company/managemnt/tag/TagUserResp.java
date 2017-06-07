/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag;

import java.util.List;

import org.aposoft.wechat.company.managemnt.user.User;

import cn.aposoft.wechat.WechatResp;

/**
 * 根据标签读取成员的返回列表
 * 
 * @author Jann Liu
 *
 */
public class TagUserResp extends WechatResp {
	private static final long serialVersionUID = -1277639463039991992L;

	private List<User> userlist;

	private int[] partylist;

	/**
	 * @return the userlist
	 */
	public List<User> getUserlist() {
		return userlist;
	}

	/**
	 * @param userlist
	 *            the userlist to set
	 */
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	/**
	 * @return the partylist
	 */
	public int[] getPartylist() {
		return partylist;
	}

	/**
	 * @param partylist
	 *            the partylist to set
	 */
	public void setPartylist(int[] partylist) {
		this.partylist = partylist;
	}

}
