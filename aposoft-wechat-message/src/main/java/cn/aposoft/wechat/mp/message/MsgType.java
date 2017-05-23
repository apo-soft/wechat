/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message;

/**
 * 微信消息类型枚举
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public enum MsgType {
	/**
	 * 文本类型
	 */
	text,
	/**
	 * 图片
	 */
	image,
	/**
	 * 语音
	 */
	voice,
	/**
	 * 视频
	 */
	video,
	/**
	 * 音乐
	 */
	music,
	/**
	 * 图文
	 */
	news,
	/**
	 * 事件 event
	 */
	event,
	/**
	 * 微信新闻
	 */
	mpnews,
	/**
	 * 微信卡券
	 */
	wxcard;
}
