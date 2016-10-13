/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message;

/**
 * 微信消息类型枚举
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public enum MsgType {
    /**
     * 文本类型
     */
    Text("text"),
    /**
     * 图片
     */
    Image("image"),
    /**
     * 语音
     */
    Voice("voice"),
    /**
     * 视频
     */
    Video("video"),
    /**
     * 音乐
     */
    Music("music"),
    /**
     * 图文
     */
    News("news");
    private final String code;

    private MsgType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
