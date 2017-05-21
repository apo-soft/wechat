/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.util.List;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * <pre>
 * 	{
		 "total":23000,
		 "count":10000,
		 "data":{"
		    openid":[
		       "OPENID1",
		       "OPENID2",
		       ...,
		       "OPENID10000"
		    ]
		  },
		  "next_openid":"OPENID10000"
		}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class BlackListResp extends WechatResp {
	private static final long serialVersionUID = -5183366233067885689L;
	private int total;
	private int count;
	private String next_openid;

	private OpenIdHolder data;

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the next_openid
	 */
	public String getNext_openid() {
		return next_openid;
	}

	/**
	 * @param next_openid
	 *            the next_openid to set
	 */
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	/**
	 * @return the data
	 */
	public OpenIdHolder getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(OpenIdHolder data) {
		this.data = data;
	}

	public static class OpenIdHolder {
		private List<String> openid;

		/**
		 * @return the openid
		 */
		public List<String> getOpenid() {
			return openid;
		}

		/**
		 * @param openid
		 *            the openid to set
		 */
		public void setOpenid(List<String> openid) {
			this.openid = openid;
		}
	}
}
