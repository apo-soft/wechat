/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信接收消息类型集合类
 * 
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
@XmlRootElement(namespace = "", name = "xml")
public class AposoftIntegratedMessage extends ReceivedMessage implements Text {
    private static final long serialVersionUID = 8816478589951659637L;

    private String content;

    /**
     * 读取内容
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *            the content to set
     */
    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }
    
    

}
