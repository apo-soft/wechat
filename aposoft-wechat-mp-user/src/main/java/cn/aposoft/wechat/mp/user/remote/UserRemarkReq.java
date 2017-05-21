/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

/**
 * 用户标签请求
 * 
 * @author Jann Liu
 *
 */
public class UserRemarkReq {

	public UserRemarkReq(String openid, String remark) {
		this.openid = openid;
		this.remark = remark;
	}

	// "openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",
	private String openid;
	// "remark":"pangzi"
	private String remark;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
