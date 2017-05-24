/**
 * 
 */
package cn.aposoft.wechat.mp.account.remote;

/**
 * 二维码响应内容
 * 
 * @author Jann Liu
 *
 */
public class QrcodeResp {
	private Integer expire_seconds;
	private String url;
	private String ticket;

	/**
	 * @return the expire_seconds
	 */
	public Integer getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds
	 *            the expire_seconds to set
	 */
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
