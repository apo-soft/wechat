/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import cn.aposoft.wechat.WechatResp;

/**
 * 微信用户基本信息
 * 
 * <pre>
	 参数说明
	subscribe	用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	openid	用户的标识，对当前公众号唯一
	nickname	用户的昵称
	sex	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	city	用户所在城市
	country	用户所在国家
	province	用户所在省份
	language	用户的语言，简体中文为zh_CN
	headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	subscribe_time	用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	unionid	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	remark	公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	groupid	用户所在的分组ID（兼容旧的用户分组接口）
	tagid_list	用户被打上的标签ID列表
	错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:{"errcode":40013,"errmsg":"invalid appid"}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class UserInfoResp extends WechatResp {
	private static final long serialVersionUID = -7498708801875035751L;
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
