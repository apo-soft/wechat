/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template;

import cn.aposoft.wechat.mp.message.MsgType;

/**
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface Message {

    /**
     * ToUserName 是 接收方帐号（收到的OpenID）
     */
    public void setToUser(String toUser);

    /**
     * FromUserName 是 开发者微信号
     */
    public void setFromUser(String fromUser);

    /**
     * CreateTime 是 消息创建时间 （整型）
     */
    public void setCreateTime(String createTime);

    /**
     * MsgType 是{@link MsgType#getCode()}
     */
    public void setMsgType(String msgType);

    /**
     * ToUserName 是 接收方帐号（收到的OpenID）
     */
    public String getToUser();

    /**
     * FromUserName 是 开发者微信号
     */
    public String getFromUser();

    /**
     * CreateTime 是 消息创建时间 （整型）
     */
    public String getCreateTime();

    /**
     * MsgType 是{@link MsgType#getCode()}
     */
    public String getMsgType();
}
