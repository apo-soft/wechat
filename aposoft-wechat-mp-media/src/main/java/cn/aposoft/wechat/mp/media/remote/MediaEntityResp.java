/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import cn.aposoft.wechat.MediaEntity;
import cn.aposoft.wechat.mp.WechatResp;

/**
 * 素材内容响应对象
 * 
 * @author Jann Liu
 *
 */
public class MediaEntityResp extends WechatResp {
	private static final long serialVersionUID = -9113425866925288421L;
	// 素材文件数据
	private MediaEntity media;
	// 视频url
	private String video_url;

	/**
	 * 视频消息素材
	 * 
	 * @return the video_url
	 */
	public String getVideo_url() {
		return video_url;
	}

	/**
	 * 视频消息素材
	 * 
	 * @param video_url
	 *            the video_url to set
	 */
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	/**
	 * @return the media
	 */
	public MediaEntity getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(MediaEntity media) {
		this.media = media;
	}
}
