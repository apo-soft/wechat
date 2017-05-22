/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Jann Liu
 *
 */
public class MediaItem implements Serializable {
	private static final long serialVersionUID = -7365816807190689735L;

	private String media_id;// news
	private String url;
	private Long update_time;// news
	private String name;
	private NewsContent content;// news

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
	 * @return the update_time
	 */
	public Long getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time
	 *            the update_time to set
	 */
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
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
	 * @return the content
	 */
	public NewsContent getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(NewsContent content) {
		this.content = content;
	}

}
