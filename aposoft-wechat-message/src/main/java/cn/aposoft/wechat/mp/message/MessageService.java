/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message;

import cn.aposoft.wechat.mp.message.template.Message;

/**
 * 默认应答消息服务
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public interface MessageService {

    /**
     * 根据用户输入消息，返回指定的消息，默认返回{@link cn.aposoft.wechat.mp.message.template.Success}
     */
    public Message getReplyMessage(Message receivedMessage);
}
