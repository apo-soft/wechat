/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
@XmlRootElement(namespace = "", name = "xml")
public class Text extends ReceivedMessage {
    private static final long serialVersionUID = -8295276303621890884L;

    private String content;

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }
}
