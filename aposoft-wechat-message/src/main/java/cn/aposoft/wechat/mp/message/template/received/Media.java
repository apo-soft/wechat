/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * 素材资源消息接口
 * 
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface Media extends WechatReceivedMessage {

    /**
     * 素材了资源ID
     * 
     * @return 素材资源ID
     */
    public String getMediaId();
}
