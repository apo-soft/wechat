/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template;

import java.io.Serializable;

import cn.aposoft.wechat.mp.message.MsgType;

/**
 * 微信响应的消息基类
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class Message implements Serializable {
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

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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
