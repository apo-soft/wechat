/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message;

import cn.aposoft.wechat.mp.message.template.Message;

/**
 * 默认应答消息服务
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public interface MessageReplyService {

    public Message getDefaultReplyMessage(String toUser);
}
