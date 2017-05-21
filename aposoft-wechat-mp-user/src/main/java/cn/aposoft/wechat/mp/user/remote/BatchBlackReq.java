/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.util.List;

/**
 * @author Jann Liu
 *
 */
public class BatchBlackReq {
	private List<String> openid_list;

	/**
	 * @return the opened_list
	 */
	public List<String> getOpenid_list() {
		return openid_list;
	}

	/**
	 * @param opened_list
	 *            the opened_list to set
	 */
	public void setOpenid_list(List<String> openid_list) {
		this.openid_list = openid_list;
	}
}
