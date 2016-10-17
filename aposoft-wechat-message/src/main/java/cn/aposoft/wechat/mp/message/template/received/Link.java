package cn.aposoft.wechat.mp.message.template.received;

public interface Link extends ReceivedMessage {

    /**
     * 标题
     * 
     * @return 标题
     */
    public String getTitle();

    /**
     * 消息描述
     * 
     * @return 消息描述
     */
    public String getDescription();

    /**
     * 消息链接
     * 
     * @return 消息链接
     */
    public String getUrl();

}
