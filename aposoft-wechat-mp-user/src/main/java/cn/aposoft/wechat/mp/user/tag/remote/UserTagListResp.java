/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag.remote;

import java.util.List;

import cn.aposoft.wechat.mp.remote.WechatResp;
import cn.aposoft.wechat.mp.user.tag.UserTag;

/**
 * @author Jann Liu
 *
 */
public class UserTagListResp extends WechatResp {
	private static final long serialVersionUID = 7165885928326198739L;
	private List<UserTag> tags;

	/**
	 * @return the tags
	 */
	public List<UserTag> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<UserTag> tags) {
		this.tags = tags;
	}

}
