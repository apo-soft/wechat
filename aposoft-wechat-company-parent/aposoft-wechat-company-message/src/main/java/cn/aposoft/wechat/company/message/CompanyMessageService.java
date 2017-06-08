/**
 * 
 */
package cn.aposoft.wechat.company.message;

import java.io.Closeable;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.company.message.remote.MessageResp;
import cn.aposoft.wechat.mp.media.news.NewsContent;
import cn.aposoft.wechat.mp.message.remote.MediaIdHolder;
import cn.aposoft.wechat.mp.message.template.News;
import cn.aposoft.wechat.mp.message.template.Video;

/**
 * 企业消息服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface CompanyMessageService extends Closeable {
	/**
	 * 发送文本
	 * 
	 * @return 发送结果
	 */
	public MessageResp sendText(String accessToken, RequestConfig config, String content) throws RemoteException;

	/**
	 * 发送图片
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendImage(String accessToken, RequestConfig config, MediaIdHolder media) throws RemoteException;

	/**
	 * 发送语音
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendVoice(String accessToken, RequestConfig config, MediaIdHolder content)
			throws RemoteException;

	/**
	 * 发送视频
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendVideo(String accessToken, RequestConfig config, Video video) throws RemoteException;

	/**
	 * 发送文件
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendFile(String accessToken, RequestConfig config, MediaIdHolder file) throws RemoteException;

	/**
	 * 发送新闻
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendNews(String accessToken, RequestConfig config, News news) throws RemoteException;

	/**
	 * 发送微信新闻
	 * 
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendMpnews(String accessToken, RequestConfig config, NewsContent mpnews) throws RemoteException;

	@Override
	public void close();
}
