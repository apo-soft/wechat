/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public interface Text extends ReceivedMessage {

    /**
     * @return 文本类型消息内容
     */
    public String getContent();
}
