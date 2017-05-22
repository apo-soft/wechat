/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 素材数量统计
 * 
 * <pre>
 * {
	 "voice_count":COUNT,
	 "video_count":COUNT,
	 "image_count":COUNT,
	 "news_count":COUNT
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class MeidaCountResp extends WechatResp {
	private static final long serialVersionUID = -6256494546129879698L;
	// "voice_count":COUNT,
	private Integer voice_count;
	// "video_count":COUNT,
	private Integer video_count;
	// "image_count":COUNT,
	private Integer image_count;
	// "news_count":COUNT
	private Integer news_count;

	/**
	 * @return the voice_count
	 */
	public Integer getVoice_count() {
		return voice_count;
	}

	/**
	 * @param voice_count
	 *            the voice_count to set
	 */
	public void setVoice_count(Integer voice_count) {
		this.voice_count = voice_count;
	}

	/**
	 * @return the video_count
	 */
	public Integer getVideo_count() {
		return video_count;
	}

	/**
	 * @param video_count
	 *            the video_count to set
	 */
	public void setVideo_count(Integer video_count) {
		this.video_count = video_count;
	}

	/**
	 * @return the image_count
	 */
	public Integer getImage_count() {
		return image_count;
	}

	/**
	 * @param image_count
	 *            the image_count to set
	 */
	public void setImage_count(Integer image_count) {
		this.image_count = image_count;
	}

	/**
	 * @return the news_count
	 */
	public Integer getNews_count() {
		return news_count;
	}

	/**
	 * @param news_count
	 *            the news_count to set
	 */
	public void setNews_count(Integer news_count) {
		this.news_count = news_count;
	}

}
