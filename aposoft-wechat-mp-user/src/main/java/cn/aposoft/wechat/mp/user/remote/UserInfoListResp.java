/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.util.List;

import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.user.UserInfo;

/**
 * 用户信息列表
 * 
 * @author liuya
 *
 */
public class UserInfoListResp extends WechatResp {

	private static final long serialVersionUID = 4232593980354641932L;
	private List<UserInfo> user_info_list;

	public List<UserInfo> getUser_info_list() {
		return user_info_list;
	}

	public void setUser_info_list(List<UserInfo> user_info_list) {
		this.user_info_list = user_info_list;
	}

}
