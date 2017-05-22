/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jann Liu
 *
 */
public class NewsContent implements Serializable {
	private static final long serialVersionUID = 4064719268380432661L;
	private List<NewsItem> news_item; // news
	private Long update_time;
	private Long create_time;

	/**
	 * @return the news_item
	 */
	public List<NewsItem> getNews_item() {
		return news_item;
	}

	/**
	 * @param news_item
	 *            the news_item to set
	 */
	public void setNews_item(List<NewsItem> news_item) {
		this.news_item = news_item;
	}

	/**
	 * @return the update_time
	 */
	public Long getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time
	 *            the update_time to set
	 */
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
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

}
