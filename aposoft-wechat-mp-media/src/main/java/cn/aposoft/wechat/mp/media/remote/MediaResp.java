/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 素材响应对象 {@code {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}}
 * 
 * @author Jann Liu
 *
 */
public class MediaResp extends WechatResp {
	private static final long serialVersionUID = 3588426913939192540L;
	private String type;
	private String media_id;
	private long created_at;
	private String url;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id
	 *            the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	/**
	 * @return the created_at
	 */
	public long getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(long created_at) {
		this.created_at = created_at;
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

}
