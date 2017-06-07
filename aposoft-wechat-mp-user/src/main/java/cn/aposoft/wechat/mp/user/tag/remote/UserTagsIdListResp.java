/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag.remote;

import java.util.List;

import cn.aposoft.wechat.mp.WechatResp;

/**
 * 列举用户标签列表响应
 * 
 * @author Jann Liu
 *
 */
public class UserTagsIdListResp extends WechatResp {
	private static final long serialVersionUID = 8505691027620221493L;
	private List<Integer> tagid_list;

	/**
	 * @return the tagid_list
	 */
	public List<Integer> getTagid_list() {
		return tagid_list;
	}

	/**
	 * @param tagid_list
	 *            the tagid_list to set
	 */
	public void setTagid_list(List<Integer> tagid_list) {
		this.tagid_list = tagid_list;
	}
}
