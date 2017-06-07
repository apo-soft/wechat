/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import cn.aposoft.wechat.mp.WechatResp;

/**
 * @author Jann Liu
 *
 */
public class UserResp extends WechatResp {
	private static final long serialVersionUID = 4118395281708473511L;
	private int total;
	private int count;
	private String next_openid;
	private OpenIdContainer data;

	/**
	 * @return total user
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            total user
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return currentCount
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * @return currentCount
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	public OpenIdContainer getData() {
		return data;
	}

	public void setData(OpenIdContainer data) {
		this.data = data;
	}

	public static class OpenIdContainer {
		private String[] openid;

		public String[] getOpenid() {
			return openid;
		}

		public void setOpenid(String[] openid) {
			this.openid = openid;
		}
	}

}
