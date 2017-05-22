package cn.aposoft.wechat.mp.media.remote;

import java.io.Serializable;

/**
 * 素材消息
 * 
 * @author Jann Liu
 *
 */
public class NewsItem implements Serializable {
	private static final long serialVersionUID = -8678633746688586896L;

	// "title": TITLE,
	private String title;
	// "thumb_media_id": THUMB_MEDIA_ID,
	private String thumb_media_id;
	// "show_cover_pic": SHOW_COVER_PIC(0 / 1),
	private Integer show_cover_pic;
	// "author": AUTHOR,
	private String author;
	// "digest": DIGEST,
	private String digest;
	// "content": CONTENT,
	private String content;
	// "url": URL,
	private String url;
	// "content_source_url": CONTETN_SOURCE_URL
	private String content_source_url;

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
	 * @return the thumb_media_id
	 */
	public String getThumb_media_id() {
		return thumb_media_id;
	}

	/**
	 * @param thumb_media_id
	 *            the thumb_media_id to set
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	/**
	 * @return the show_cover_pic
	 */
	public Integer getShow_cover_pic() {
		return show_cover_pic;
	}

	/**
	 * @param show_cover_pic
	 *            the show_cover_pic to set
	 */
	public void setShow_cover_pic(Integer show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * @param digest
	 *            the digest to set
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the content_source_url
	 */
	public String getContent_source_url() {
		return content_source_url;
	}

	/**
	 * @param content_source_url
	 *            the content_source_url to set
	 */
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

}
