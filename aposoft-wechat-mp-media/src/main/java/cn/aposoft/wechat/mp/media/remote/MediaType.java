/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

/**
 * 临时素材格式
 * 
 * @author Jann Liu
 *
 */
public enum MediaType {
	/**
	 * 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	 */
	image,
	/**
	 * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	 */
	voice,
	/**
	 * 视频（video）：10MB，支持MP4格式
	 */
	video,
	/**
	 * 缩略图（thumb）：64KB，支持JPG格式
	 */
	thumb
}
