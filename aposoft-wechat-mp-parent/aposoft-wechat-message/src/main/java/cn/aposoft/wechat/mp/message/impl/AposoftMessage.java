/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.template.Message;

/**
 * 微信响应的消息基类
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class AposoftMessage implements Message, Serializable {
    private static final long serialVersionUID = -9068509663236949433L;
    /**
     * ToUserName 是 接收方帐号（收到的OpenID）
     */
    private String toUser;
    /**
     * FromUserName 是 开发者微信号
     */
    private String fromUser;
    /**
     * CreateTime 是 消息创建时间 （整型）
     */
    private String createTime;
    /**
     * MsgType 是{@link MsgType#getCode()}
     */
    private String msgType;

    @XmlElement(name = "ToUserName")
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    @XmlElement(name = "FromUserName")
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getToUser() {
        return toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getMsgType() {
        return msgType;
    }
}
