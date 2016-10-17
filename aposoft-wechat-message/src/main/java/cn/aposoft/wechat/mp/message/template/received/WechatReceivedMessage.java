/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

import cn.aposoft.wechat.mp.message.template.WechatMessage;

/**
 * 接受类消息
 * 
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface WechatReceivedMessage extends WechatMessage {
    /**
     * 消息id，64位整型
     * 
     * @return 消息id，64位整型
     */
    public String getMsgId();
}
