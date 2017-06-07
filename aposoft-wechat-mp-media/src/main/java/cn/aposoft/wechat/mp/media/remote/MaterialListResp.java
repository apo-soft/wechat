/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.util.List;

import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.media.news.MaterialItem;

/**
 * 素材列表
 * 
 * <pre>
 * {
	  "total_count": TOTAL_COUNT,
	  "item_count": ITEM_COUNT,
	  "item": [{
	      "media_id": MEDIA_ID,
	      "content": {
	          "news_item": [{
	              "title": TITLE,
	              "thumb_media_id": THUMB_MEDIA_ID,
	              "show_cover_pic": SHOW_COVER_PIC(0 / 1),
	              "author": AUTHOR,
	              "digest": DIGEST,
	              "content": CONTENT,
	              "url": URL,
	              "content_source_url": CONTETN_SOURCE_URL
	          },
	          //多图文消息会在此处有多篇文章
	          ]
	       },
	       "update_time": UPDATE_TIME
	   },
	   //可能有多个图文消息item结构
	 ]
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class MaterialListResp extends WechatResp {
	private static final long serialVersionUID = 3949321367960356856L;
	private Integer total_count;
	private Integer item_count;
	private List<MaterialItem> item;

	/**
	 * @return the total_count
	 */
	public Integer getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count
	 *            the total_count to set
	 */
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the item_count
	 */
	public Integer getItem_count() {
		return item_count;
	}

	/**
	 * @param item_count
	 *            the item_count to set
	 */
	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}

	/**
	 * @return the item
	 */
	public List<MaterialItem> getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(List<MaterialItem> item) {
		this.item = item;
	}

}
