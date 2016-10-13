/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template;

import java.util.List;

/**
 * <pre>
 * 参数   是否必须    说明

 * </pre>
 * 
 * <pre>
      <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>12345678</CreateTime>
            <MsgType><![CDATA[news]]></MsgType>
            <ArticleCount>2</ArticleCount>
            <Articles>
                <item>
                    <Title><![CDATA[title1]]></Title> 
                    <Description><![CDATA[description1]]></Description>
                    <PicUrl><![CDATA[picurl]]></PicUrl>
                    <Url><![CDATA[url]]></Url>
                </item>
                <item>
                    <Title><![CDATA[title]]></Title>
                    <Description><![CDATA[description]]></Description>
                    <PicUrl><![CDATA[picurl]]></PicUrl>
                    <Url><![CDATA[url]]></Url>
                </item>
            </Articles>
        </xml>
 * </pre>
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class News extends Message {
    private static final long serialVersionUID = 7331378356472047103L;
    /**
     * ArticleCount 是 图文消息个数，限制为10条以内
     */
    private int articleCount;
    /**
     * Articles 是 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
     */
    private List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    /**
     * 重载toString方法,按微信要求格式返回字符串
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<xml>")//
                .append("<ToUserName><![CDATA").append(getToUser()).append("]]></ToUserName>")//
                .append("<FromUserName><![CDATA[").append(getFromUser()).append("]]></FromUserName>")//
                .append("<CreateTime>").append(getCreateTime()).append("</CreateTime>")//
                .append("<MsgType><![CDATA[").append(getMsgType()).append("]]></MsgType>")//
                .append("<ArticleCount>").append(getArticleCount()).append("</ArticleCount>")//
                .append("<Articles>");
        for (Article article : articles) {
            builder.append(article);
        }
        builder.append("</Articles>")//
                .append("</xml>");
        return builder.toString();
    }
}
