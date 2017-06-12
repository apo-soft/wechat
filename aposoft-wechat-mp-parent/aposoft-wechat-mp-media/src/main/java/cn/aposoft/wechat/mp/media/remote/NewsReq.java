/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.Serializable;

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
 * <pre>
 * 参数					是否必须	说明
	media_id 			是 		要修改的图文消息的id
	index				是		要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	title	 			是 		标题
	thumb_media_id		是		图文消息的封面图片素材id（必须是永久mediaID）
	author				是		作者
	digest				是		图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	show_cover_pic		是		是否显示封面，0为false，即不显示，1为true，即显示
	content				是		图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	content_source_url	是		图文消息的原文地址，即点击“阅读原文”后的URL
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class NewsReq implements Serializable {
	private static final long serialVersionUID = 6219597671871833299L;
	// "media_id":MEDIA_ID,
	private String media_id;
	// index 默认为0,表示第一篇图文资料
	private Integer index = 0;
	private NewsItem articles;

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
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the articles
	 */
	public NewsItem getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(NewsItem articles) {
		this.articles = articles;
	}

}
