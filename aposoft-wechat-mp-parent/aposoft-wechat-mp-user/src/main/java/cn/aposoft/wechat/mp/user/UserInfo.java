/**
 * 
 */
package cn.aposoft.wechat.mp.user;

import java.io.Serializable;

/**
 * @author Jann Liu
 *
 */
public class UserInfo implements Serializable {
	private static final long serialVersionUID = -2053756942094091868L;
	// "subscribe": 1,
	private int subscribe;
	// "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
	private String openid;
	// "nickname": "Band",
	private String nickname;
	// "sex": 1,
	private int sex;
	// "language": "zh_CN",
	private String language;
	// "city": "广州",
	private String city;
	// "province": "广东",
	private String province;
	// "country": "中国",
	private String country;
	// "headimgurl":
	// "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4
	// eMsv84eavHiaiceqxibJxCfHe/0",
	private String headimgurl;
	// "subscribe_time": 1382694957,
	private String subscribe_time;
	// "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
	private String unionid;
	// "remark": "",
	private String remark;
	// "groupid": 0,
	private int groupid;
	// "tagid_list":[128,2]
	private int[] tagid_list;

	public int getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public int[] getTagid_list() {
		return tagid_list;
	}

	public void setTagid_list(int[] tagid_list) {
		this.tagid_list = tagid_list;
	}

}
