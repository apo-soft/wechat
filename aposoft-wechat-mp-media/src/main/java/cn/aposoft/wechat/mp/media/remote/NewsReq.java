/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 *
 * 
 * <pre>
 *{
	 "media_id":MEDIA_ID,
	 "index":INDEX,
	 "articles": {
	      "title": TITLE,
	      "thumb_media_id": THUMB_MEDIA_ID,
	      "author": AUTHOR,
	      "digest": DIGEST,
	      "show_cover_pic": SHOW_COVER_PIC(0 / 1),
	      "content": CONTENT,
	      "content_source_url": CONTENT_SOURCE_URL
	   }
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class NewsReq extends NewsItem {
	private static final long serialVersionUID = 6219597671871833299L;
	// "media_id":MEDIA_ID,
	private String media_id;

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
}
