/**
 * 
 */
package cn.aposoft.wechat.mp.message;

import java.util.List;

import cn.aposoft.io.QuietCloseable;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.mp.message.template.Article;
import cn.aposoft.wechat.mp.message.template.Music;
import cn.aposoft.wechat.mp.message.template.Video;

/**
 * 客服消息发送服务
 * 
 * @author Jann Liu
 *
 */
public interface CsaMessageService extends QuietCloseable {

	/**
	 * 发送卡券信息
	 * 
	 * @param openId
	 *            公众号ID
	 * @param cardId
	 *            卡ID
	 * @return 发送结果
	 */
	WechatResp sendCard(String accessToken, String openId, String cardId) throws RemoteException;

	/**
	 * 发送卡券信息
	 * 
	 * @param openId
	 *            公众号ID
	 * @param cardId
	 *            卡ID
	 * @param account
	 *            客服账号
	 * 
	 * @return 发送结果
	 */
	WechatResp sendCard(String accessToken, String openId, String cardId, String account) throws RemoteException;

	/**
	 * 发送微信公众号新闻
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            新闻ID
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendMpNews(String accessToken, String openId, String mediaId) throws RemoteException;

	/**
	 * 发送微信公众号新闻
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            新闻ID
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendMpNews(String accessToken, String openId, String mediaId, String account) throws RemoteException;

	/**
	 * 发送外链新闻
	 * 
	 * @param openId
	 *            公众号
	 * @param articles
	 *            新闻列表<8条
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendNews(String accessToken, String openId, List<Article> articles) throws RemoteException;

	/**
	 * 发送外链新闻
	 * 
	 * @param openId
	 *            公众号
	 * @param articles
	 *            新闻列表<8条
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendNews(String accessToken, String openId, List<Article> articles, String account)
			throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            音乐信息
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendMusic(String accessToken, String openId, Music music) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            音乐信息
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendMusic(String accessToken, String openId, Music music, String account) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param vedio
	 *            视频信息
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendVedio(String accessToken, String openId, Video vedio) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param vedio
	 *            视频信息
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendVedio(String accessToken, String openId, Video vedio, String account) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            媒体对象ID
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendVoice(String accessToken, String openId, String mediaId, String account) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            媒体对象ID
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendVoice(String accessToken, String openId, String mediaId) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            媒体对象ID
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendImage(String accessToken, String openId, String mediaId, String account) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param mediaId
	 *            媒体对象ID
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendImage(String accessToken, String openId, String mediaId) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param content
	 *            发送消息内容
	 * @param account
	 *            客服账号
	 * @return 发送结果
	 * @throws RemoteException
	 */
	WechatResp sendText(String accessToken, String openId, String content, String account) throws RemoteException;

	/**
	 * 
	 * @param openId
	 *            公众号
	 * @param content
	 *            发送消息内容
	 * @return 发送结果
	 *         <p>
	 * 		{"errcode":40003,"errmsg":"invalid openid hint:
	 *         [0qdjPA0465ge21]"}
	 * @throws RemoteException
	 */
	WechatResp sendText(String accessToken, String openId, String content) throws RemoteException;

	@Override
	public void close();

}
