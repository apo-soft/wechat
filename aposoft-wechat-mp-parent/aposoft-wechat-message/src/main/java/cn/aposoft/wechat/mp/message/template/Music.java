/**
 * 
 */
package cn.aposoft.wechat.mp.message.template;

/**
 * 微信音乐类型
 * 
 * @author liuya
 *
 */
public class Music {

	// "title":"MUSIC_TITLE",
	private String title;
	// "description":"MUSIC_DESCRIPTION",
	private String description;
	// "musicurl":"MUSIC_URL",
	private String musicurl;
	// "hqmusicurl":"HQ_MUSIC_URL",
	private String hqmusicurl;
	// "thumb_media_id":"THUMB_MEDIA_ID"
	private String thumb_media_id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

}
