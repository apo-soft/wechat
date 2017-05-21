/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * 素材资源消息接口
 * 
 * @author Jann Liu
 * @date 2016年10月17日
 * 
 */
public interface Media extends ReceivedMessage {

    /**
     * 素材了资源ID
     * 
     * @return 素材资源ID
     */
    public String getMediaId();
}
