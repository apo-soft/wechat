/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.reply;

import java.io.Serializable;

/**
 * 
 * 公众号NewsTemplate 嵌入式 Article
 * 
 * <pre>
 * <item>
        <Title><![CDATA[title]]></Title>
        <Description><![CDATA[description]]></Description>
        <PicUrl><![CDATA[picurl]]></PicUrl>
        <Url><![CDATA[url]]></Url>
    </item>
 * </pre>
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -2737890835267492067L;
    /**
     * Title 否 图文消息标题
     */
    private String title;
    /**
     * Description 否 图文消息描述
     */
    private String description;
    /**
     * PicUrl 否 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    private String picurl;
    /**
     * Url 否 点击图文消息跳转链接
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 重载toString方法,按微信要求格式返回字符串
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<Title><![CDATA[").append(title).append("]]></Title>");
        builder.append("<Description><![CDATA[").append(description).append("]]></Description>");
        builder.append("<PicUrl><![CDATA[").append(picurl).append("]]></PicUrl>");
        builder.append("<Url><![CDATA[").append(url).append("]]></Url>");
        builder.append("</item>");
        return builder.toString();

    }
}
