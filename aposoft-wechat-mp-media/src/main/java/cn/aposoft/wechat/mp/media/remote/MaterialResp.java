/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.util.List;

import cn.aposoft.wechat.MediaEntity;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 * 素材响应
 * 
 * <pre>
 * {
	 "title":TITLE,
	 "description":DESCRIPTION,
	 "down_url":DOWN_URL,
	}
 * </pre>
 * 
 * <pre>
 * {
	"news_item":
	[
	    {
	    "title":TITLE,
	    "thumb_media_id"::THUMB_MEDIA_ID,
	    "show_cover_pic":SHOW_COVER_PIC(0/1),
	    "author":AUTHOR,
	    "digest":DIGEST,
	    "content":CONTENT,
	    "url":URL,
	    "content_source_url":CONTENT_SOURCE_URL
	    },
	    //多图文消息有多篇文章
	 ]
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class MaterialResp extends WechatResp {
	private static final long serialVersionUID = -1817576108628900482L;
	private String title;
	private String description;
	private String down_url;
	private MediaEntity mediaEntity;
	private List<NewsItem> news_item;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the down_url
	 */
	public String getDown_url() {
		return down_url;
	}

	/**
	 * @param down_url
	 *            the down_url to set
	 */
	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}

	/**
	 * @return the news_item
	 */
	public List<NewsItem> getNews_item() {
		return news_item;
	}

	/**
	 * @param news_item
	 *            the news_item to set
	 */
	public void setNews_item(List<NewsItem> news_item) {
		this.news_item = news_item;
	}

	/**
	 * @return the media
	 */
	public MediaEntity getMediaEntity() {
		return mediaEntity;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMediaEntity(MediaEntity mediaEntity) {
		this.mediaEntity = mediaEntity;
	}

}
