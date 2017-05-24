/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * {
    "is_add_friend_reply_open":1,
    "is_autoreply_open":1,
    "add_friend_autoreply_info":{
        "type":"text",
        "content":"Thanks for your attention!"
    },
    "message_default_autoreply_info":{
        "type":"text",
        "content":"Hello, this is autoreply!"
    },
    "keyword_autoreply_info":{
        "list":[
            {
                "rule_name":"autoreply-news",
                "create_time":1423028166,
                "reply_mode":"reply_all",
                "keyword_list_info":[
                    {
                        "type":"text",
                        "match_mode":"contain",
                        "content":"news测试"
                    }
                ],
                "reply_list_info":[
                    {
                        "type":"news",
                        "news_info":{
                            "list":[
                                {
                                    "title":"it's news",
                                    "author":"jim",
                                    "digest":"it's digest",
                                    "show_cover":1,
                                    "cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0",
                                    "content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd",
                                    "source_url":"http://www.url.com"
                                }
                            ]
                        }
                    },
                    {
                        "type":"news",
                        "content":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o",
                        "news_info":{
                            "list":[
                                {
                                    "title":"MULTI_NEWS",
                                    "author":"JIMZHENG",
                                    "digest":"text",
                                    "show_cover":0,
                                    "cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0",
                                    "content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd",
                                    "source_url":""
                                },
                                {
                                    "title":"MULTI_NEWS4",
                                    "author":"JIMZHENG",
                                    "digest":"MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT",
                                    "show_cover":1,
                                    "cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0",
                                    "content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=5&sn=b4ef73a915e7c2265e437096582774af#rd",
                                    "source_url":""
                                }
                            ]
                        }
                    }
                ]
            },
            {
                "rule_name":"autoreply-voice",
                "create_time":1423027971,
                "reply_mode":"random_one",
                "keyword_list_info":[
                    {
                        "type":"text",
                        "match_mode":"contain",
                        "content":"voice测试"
                    }
                ],
                "reply_list_info":[
                    {
                        "type":"voice",
                        "content":"NESsxgHEvAcg3egJTtYj4uG1PTL6iPhratdWKDLAXYErhN6oEEfMdVyblWtBY5vp"
                    }
                ]
            },
            {
                "rule_name":"autoreply-text",
                "create_time":1423027926,
                "reply_mode":"random_one",
                "keyword_list_info":[
                    {
                        "type":"text",
                        "match_mode":"contain",
                        "content":"text测试"
                    }
                ],
                "reply_list_info":[
                    {
                        "type":"text",
                        "content":"hello!text!"
                    }
                ]
            },
            {
                "rule_name":"autoreply-video",
                "create_time":1423027801,
                "reply_mode":"random_one",
                "keyword_list_info":[
                    {
                        "type":"text",
                        "match_mode":"equal",
                        "content":"video测试"
                    }
                ],
                "reply_list_info":[
                    {
                        "type":"video",
                        "content":"http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&sha=0&save=1"
                    }
                ]
            }
        ]
    }
}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class AutoReplyRuleResp implements Serializable {
	private static final long serialVersionUID = 6704515477625491481L;
	private Integer is_add_friend_reply_open;
	private Integer is_autoreply_open;
	private TextAutoReply add_friend_autoreply_info;
	private TextAutoReply message_default_autoreply_info;
	private List<?> keyword_autoreply_info;

	/**
	 * @return the is_add_friend_reply_open
	 */
	public Integer getIs_add_friend_reply_open() {
		return is_add_friend_reply_open;
	}

	/**
	 * @param is_add_friend_reply_open
	 *            the is_add_friend_reply_open to set
	 */
	public void setIs_add_friend_reply_open(Integer is_add_friend_reply_open) {
		this.is_add_friend_reply_open = is_add_friend_reply_open;
	}

	/**
	 * @return the is_autoreply_open
	 */
	public Integer getIs_autoreply_open() {
		return is_autoreply_open;
	}

	/**
	 * @param is_autoreply_open
	 *            the is_autoreply_open to set
	 */
	public void setIs_autoreply_open(Integer is_autoreply_open) {
		this.is_autoreply_open = is_autoreply_open;
	}

	/**
	 * @return the add_friend_autoreply_info
	 */
	public TextAutoReply getAdd_friend_autoreply_info() {
		return add_friend_autoreply_info;
	}

	/**
	 * @param add_friend_autoreply_info
	 *            the add_friend_autoreply_info to set
	 */
	public void setAdd_friend_autoreply_info(TextAutoReply add_friend_autoreply_info) {
		this.add_friend_autoreply_info = add_friend_autoreply_info;
	}

	/**
	 * @return the message_default_autoreply_info
	 */
	public TextAutoReply getMessage_default_autoreply_info() {
		return message_default_autoreply_info;
	}

	/**
	 * @param message_default_autoreply_info
	 *            the message_default_autoreply_info to set
	 */
	public void setMessage_default_autoreply_info(TextAutoReply message_default_autoreply_info) {
		this.message_default_autoreply_info = message_default_autoreply_info;
	}

	/**
	 * @return the keyword_autoreply_info
	 */
	public List<?> getKeyword_autoreply_info() {
		return keyword_autoreply_info;
	}

	/**
	 * @param keyword_autoreply_info
	 *            the keyword_autoreply_info to set
	 */
	public void setKeyword_autoreply_info(List<?> keyword_autoreply_info) {
		this.keyword_autoreply_info = keyword_autoreply_info;
	}

	public static class AutoReply implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1017714001214974006L;
		private String type;

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
	}

	public static class TextAutoReply extends AutoReply {

		private static final long serialVersionUID = 4763414686592159737L;
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
		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class NewsAutoReply extends AutoReply {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8459956691685073275L;
		private List<NewsItem> news_info;

		/**
		 * @return the news_info
		 */
		public List<NewsItem> getNews_info() {
			return news_info;
		}

		/**
		 * @param news_info
		 *            the news_info to set
		 */
		public void setNews_info(List<NewsItem> news_info) {
			this.news_info = news_info;
		}
	}

	public static class NewsItem implements Serializable {
		private static final long serialVersionUID = -8678633746688586896L;

		// "title": TITLE,
		private String title;
		// "author": AUTHOR,
		private String author;
		// "digest": DIGEST,
		private String digest;
		// "thumb_media_id": THUMB_MEDIA_ID,
		private String thumb_media_id;
		// "show_cover_pic": SHOW_COVER_PIC(0 / 1),
		private Integer show_cover;
		private String cover_url;
		// "content_source_url": CONTETN_SOURCE_URL
		private String content_url;
		// "source_url": URL,
		private String source_url;

		// 是否打开评论，0不打开，1打开
		private Integer need_open_comment;
		// 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
		private Integer only_fans_can_comment;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the thumb_media_id
		 */
		public String getThumb_media_id() {
			return thumb_media_id;
		}

		/**
		 * @param thumb_media_id
		 *            the thumb_media_id to set
		 */
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		/**
		 * @param author
		 *            the author to set
		 */
		public void setAuthor(String author) {
			this.author = author;
		}

		/**
		 * @return the digest
		 */
		public String getDigest() {
			return digest;
		}

		/**
		 * @param digest
		 *            the digest to set
		 */
		public void setDigest(String digest) {
			this.digest = digest;
		}

		/**
		 * @return the need_open_comment
		 */
		public Integer getNeed_open_comment() {
			return need_open_comment;
		}

		/**
		 * @param need_open_comment
		 *            the need_open_comment to set
		 */
		public void setNeed_open_comment(Integer need_open_comment) {
			this.need_open_comment = need_open_comment;
		}

		/**
		 * @return the only_fans_can_comment
		 */
		public Integer getOnly_fans_can_comment() {
			return only_fans_can_comment;
		}

		/**
		 * @param only_fans_can_comment
		 *            the only_fans_can_comment to set
		 */
		public void setOnly_fans_can_comment(Integer only_fans_can_comment) {
			this.only_fans_can_comment = only_fans_can_comment;
		}

		/**
		 * @return the show_cover
		 */
		public Integer getShow_cover() {
			return show_cover;
		}

		/**
		 * @param show_cover
		 *            the show_cover to set
		 */
		public void setShow_cover(Integer show_cover) {
			this.show_cover = show_cover;
		}

		/**
		 * @return the cover_url
		 */
		public String getCover_url() {
			return cover_url;
		}

		/**
		 * @param cover_url
		 *            the cover_url to set
		 */
		public void setCover_url(String cover_url) {
			this.cover_url = cover_url;
		}

		/**
		 * @return the content_url
		 */
		public String getContent_url() {
			return content_url;
		}

		/**
		 * @param content_url
		 *            the content_url to set
		 */
		public void setContent_url(String content_url) {
			this.content_url = content_url;
		}

		/**
		 * @return the source_url
		 */
		public String getSource_url() {
			return source_url;
		}

		/**
		 * @param source_url
		 *            the source_url to set
		 */
		public void setSource_url(String source_url) {
			this.source_url = source_url;
		}

	}

	public static class Keyword implements Serializable {
		private static final long serialVersionUID = -3577451135838223265L;
		private String type; // "type":"text",
		private String match_mode;// "match_mode":"contain",
		private String content;// "content":"news测试"

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the match_mode
		 */
		public String getMatch_mode() {
			return match_mode;
		}

		/**
		 * @param match_mode
		 *            the match_mode to set
		 */
		public void setMatch_mode(String match_mode) {
			this.match_mode = match_mode;
		}

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
		public void setContent(String content) {
			this.content = content;
		}

	}

	public static class KeywordAutoReply implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2069398977129398133L;
		private String rule_name;
		private Long create_time;
		private String reply_mode;
		private List<Keyword> keyword_list_info;
		private List<AutoReply> reply_list_info;

		/**
		 * @return the rule_name
		 */
		public String getRule_name() {
			return rule_name;
		}

		/**
		 * @param rule_name
		 *            the rule_name to set
		 */
		public void setRule_name(String rule_name) {
			this.rule_name = rule_name;
		}

		/**
		 * @return the create_time
		 */
		public Long getCreate_time() {
			return create_time;
		}

		/**
		 * @param create_time
		 *            the create_time to set
		 */
		public void setCreate_time(Long create_time) {
			this.create_time = create_time;
		}

		/**
		 * @return the reply_mode
		 */
		public String getReply_mode() {
			return reply_mode;
		}

		/**
		 * @param reply_mode
		 *            the reply_mode to set
		 */
		public void setReply_mode(String reply_mode) {
			this.reply_mode = reply_mode;
		}

		/**
		 * @return the keyword_list_info
		 */
		public List<Keyword> getKeyword_list_info() {
			return keyword_list_info;
		}

		/**
		 * @param keyword_list_info
		 *            the keyword_list_info to set
		 */
		public void setKeyword_list_info(List<Keyword> keyword_list_info) {
			this.keyword_list_info = keyword_list_info;
		}

		/**
		 * @return the reply_list_info
		 */
		public List<AutoReply> getReply_list_info() {
			return reply_list_info;
		}

		/**
		 * @param reply_list_info
		 *            the reply_list_info to set
		 */
		public void setReply_list_info(List<AutoReply> reply_list_info) {
			this.reply_list_info = reply_list_info;
		}

	}
}
