/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.impl;

import java.util.ArrayList;
import java.util.List;

import cn.aposoft.wechat.mp.auth.Oauth2MsgType;
import cn.aposoft.wechat.mp.auth.Oauth2Scope;
import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.message.MessageReplyService;
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.template.Article;
import cn.aposoft.wechat.mp.message.template.Message;
import cn.aposoft.wechat.mp.message.template.News;
import cn.aposoft.wechat.mp.message.template.Success;
import cn.aposoft.wechat.mp.message.template.received.ReceivedMessage;

/**
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class NewsReplyService implements MessageReplyService {

    /**
     * 根据toUser, 返回默认的联排消息
     */
    public AposoftMessage getReplyMessage(String toUser) {
        News news = new News();
        news.setFromUser(WechatMpConfigFactory.getConfig().getUserId());
        news.setToUser(toUser);
        news.setMsgType(MsgType.News.getCode());
        news.setCreateTime(String.valueOf(System.currentTimeMillis()));
        // 消息信息
        news.setArticleCount(3);
        List<Article> articles = new ArrayList<>(news.getArticleCount());
        Article article = new Article();
        article.setTitle("登录授权测试");
        article.setDescription("进入页面验证登录授权");
        // 样例,生产需要转换URL
        article.setUrl("https://www.aposoft.cn/wx/oauth2/authorize?type=" + Oauth2MsgType.ACCESS_TOKEN.getType() + "&scope="
                + Oauth2Scope.snsapi_userinfo.getScope());
        article.setPicurl("http://d.hiphotos.baidu.com/image/pic/item/7a899e510fb30f24a9a92e37cd95d143ad4b03d7.jpg");

        articles.add(article);

        Article article2 = new Article();
        article2.setTitle("查看用户信息测试");
        article2.setDescription("授权后查看用户信息");
        // 样例,生产需要转换URL
        article2.setUrl("https://www.aposoft.cn/wx/oauth2/authorize?type=" + Oauth2MsgType.USER_INFO.getType() + "&scope="
                + Oauth2Scope.snsapi_userinfo.getScope());
        article2.setPicurl("http://a.hiphotos.baidu.com/image/pic/item/f11f3a292df5e0fe0996ba065e6034a85edf722e.jpg");

        articles.add(article2);

        Article article3 = new Article();
        article3.setTitle("验证TOKEN测试");
        article3.setDescription("验证ACCESS_TOKEN有效");
        // 样例,生产需要转换URL
        article3.setUrl("https://www.aposoft.cn/wx/oauth2/authorize?type=" + Oauth2MsgType.AUTH.getType() + "&scope="
                + Oauth2Scope.snsapi_userinfo.getScope());
        article3.setPicurl("http://d.hiphotos.baidu.com/image/pic/item/42a98226cffc1e1771a5bbf94e90f603728de9e4.jpg");

        articles.add(article3);

        news.setArticles(articles);

        return news;
    }

    /**
     * 当用户输入的是Text文本时,返回News，其他条件下仅返回success
     */
    @Override
    public Message getReplyMessage(ReceivedMessage message) {

        if (MsgType.Text.getCode().equals(message.getMsgType())) {
            return getReplyMessage(message.getFromUser());
        }
        return Success.getInstance();

    }

}
