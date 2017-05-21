/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag.remote;

import cn.aposoft.wechat.mp.remote.WechatResp;
import cn.aposoft.wechat.mp.user.tag.UserTag;

/**
 * 用户标签响应对象
 * 
 * @author Jann Liu
 *
 */
public class UserTagResp extends WechatResp {
	private static final long serialVersionUID = 2600493684284036603L;
	private UserTag tag;

	public UserTag getTag() {
		return tag;
	}

	public void setTag(UserTag tag) {
		this.tag = tag;
	}
}
