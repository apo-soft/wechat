/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import cn.aposoft.wechat.WechatResp;

/**
 * 用户列表响应
 * 
 * @author Jann Liu
 *
 */
public class UserListResp extends WechatResp {
	private static final long serialVersionUID = -47340256329960866L;
	private User[] userlist;

	/**
	 * @return the userlist
	 */
	public User[] getUserlist() {
		return userlist;
	}

	/**
	 * @param userlist
	 *            the userlist to set
	 */
	public void setUserlist(User[] userlist) {
		this.userlist = userlist;
	}
}
