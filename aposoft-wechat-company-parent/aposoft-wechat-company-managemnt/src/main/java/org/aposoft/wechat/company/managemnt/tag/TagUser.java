/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag;

import java.util.List;

import org.aposoft.wechat.company.managemnt.user.User;

/**
 * 标签用户
 * 
 * @author Jann Liu
 *
 */
public class TagUser {
	private Integer tagid;

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

	/**
	 * @return the tagid
	 */
	public Integer getTagid() {
		return tagid;
	}

	/**
	 * @param tagid
	 *            the tagid to set
	 */
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
}
