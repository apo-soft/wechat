/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import java.io.Serializable;
import java.util.Map;

/**
 * <pre>
 * {
		   "userid": "zhangsan",
		   "name": "张三",
		   "department": [1, 2],
		   "position": "产品经理",
		   "mobile": "15913215421",
		   "gender": "1",
		   "email": "zhangsan@gzdev.com",
		   "weixinid": "zhangsan4dev",
		   "avatar_mediaid": "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0",
		   "extattr": {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
		}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 4275010849344339511L;
	// "userid": "zhangsan",
	private String userid;
	// "name": "张三",
	private String name;
	// "department": [1, 2],
	private int[] department;
	// "position": "产品经理",
	private String position;
	// "mobile": "15913215421",
	private String mobile;
	// "gender": "1",
	private String gender;
	// "email": "zhangsan@gzdev.com",
	private String email;
	// "weixinid": "zhangsan4dev",
	private String weixinid;
	// "avatar_mediaid": "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0",
	private String avatar_mediaid;
	// "extattr":
	// {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
	private Map<String, Attribute[]> extattr;

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public int[] getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(int[] department) {
		this.department = department;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the weixinid
	 */
	public String getWeixinid() {
		return weixinid;
	}

	/**
	 * @param weixinid
	 *            the weixinid to set
	 */
	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	/**
	 * @return the avatar_mediaid
	 */
	public String getAvatar_mediaid() {
		return avatar_mediaid;
	}

	/**
	 * @param avatar_mediaid
	 *            the avatar_mediaid to set
	 */
	public void setAvatar_mediaid(String avatar_mediaid) {
		this.avatar_mediaid = avatar_mediaid;
	}

	/**
	 * @return the extattr
	 */
	public Map<String, Attribute[]> getExtattr() {
		return extattr;
	}

	/**
	 * @param extattr
	 *            the extattr to set
	 */
	public void setExtattr(Map<String, Attribute[]> extattr) {
		this.extattr = extattr;
	}

	public static class Attribute implements Serializable {
		private static final long serialVersionUID = -505308052746180682L;
		private String name;
		private String value;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

}
