/**
 * 
 */
package cn.aposoft.wechat.meidia;

import java.io.Serializable;

/**
 * 
 * @author Jann Liu
 *
 */
public class MimeEntity implements Serializable {
	private static final long serialVersionUID = -8466194355538828019L;
	/**
	 * 二进制素材格式返回值
	 */
	private MediaEntity mediaEntity;
	/**
	 * 文本格式返回值
	 */
	private String text;
	/**
	 * 返回值格式
	 */
	private String mimeType;

	/**
	 * @return the mediaEntity
	 */
	public MediaEntity getMediaEntity() {
		return mediaEntity;
	}

	/**
	 * @param mediaEntity
	 *            the mediaEntity to set
	 */
	public void setMediaEntity(MediaEntity mediaEntity) {
		this.mediaEntity = mediaEntity;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType
	 *            the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
