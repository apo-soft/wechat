/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag.remote;

import java.io.Serializable;
import java.util.List;

/**
 * 批量打标签
 * 
 * @author Jann Liu
 *
 */
public class BatchTaggingReq implements Serializable {
	private static final long serialVersionUID = 72311567996721132L;
	// 标签ID
	private int tagid;
	// 粉丝列表
	private List<String> openid_list;

	/**
	 * @return the tagid
	 */
	public int getTagid() {
		return tagid;
	}

	/**
	 * @param tagid
	 *            the tagid to set
	 */
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	/**
	 * @return the openid_list
	 */
	public List<String> getOpenid_list() {
		return openid_list;
	}

	/**
	 * @param openid_list
	 *            the openid_list to set
	 */
	public void setOpenid_list(List<String> openid_list) {
		this.openid_list = openid_list;
	}
}
