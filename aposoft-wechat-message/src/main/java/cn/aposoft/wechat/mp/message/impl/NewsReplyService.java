/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.impl;

import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.message.MessageReplyService;
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.template.Article;
import cn.aposoft.wechat.mp.message.template.Message;
import cn.aposoft.wechat.mp.message.template.News;

/**
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class NewsReplyService implements MessageReplyService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.aposoft.wechat.mp.message.MessageReplyService#getDefaultReplyMessage()
     */
    @Override
    public Message getDefaultReplyMessage(String toUser) {
        News news = new News();
        news.setFromUser(WechatMpConfigFactory.getConfig().getUserId());
        news.setToUser(toUser);
        news.setMsgType(MsgType.News.getCode());
        news.setCreateTime(String.valueOf(System.currentTimeMillis()));
        // 消息信息
        news.setArticleCount(1);

        Article article = new Article();
        article.setTitle("登录授权测试");
        article.setDescription("进入页面验证登录授权");
        // 样例,生产需要转换URL
        article.setUrl("https://www.aposoft.cn/wx/oauth2/access_token");
        article.setPicurl("http://d.hiphotos.baidu.com/image/pic/item/42a98226cffc1e1771a5bbf94e90f603728de9e4.jpg");
        return news;
    }

}
