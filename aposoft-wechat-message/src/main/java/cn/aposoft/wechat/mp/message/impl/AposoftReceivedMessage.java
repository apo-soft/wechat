/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.impl;

import javax.xml.bind.annotation.XmlElement;

import cn.aposoft.wechat.mp.message.template.received.ReceivedMessage;

/**
 * 接收到的消息基类
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class AposoftReceivedMessage extends AposoftMessage implements ReceivedMessage {
    private static final long serialVersionUID = 7413596353714301357L;
    /**
     * 消息id，64位整型
     */
    private String msgId;

    /**
     * @return the msgId
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * @param msgId
     *            the msgId to set
     */
    @XmlElement(name = "MsgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
