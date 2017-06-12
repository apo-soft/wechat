/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.aposoft.wechat.mp.message.template.event.Event;
import cn.aposoft.wechat.mp.message.template.event.LocationEvent;
import cn.aposoft.wechat.mp.message.template.event.MenuEvent;
import cn.aposoft.wechat.mp.message.template.event.QrScanEvent;
import cn.aposoft.wechat.mp.message.template.received.Link;
import cn.aposoft.wechat.mp.message.template.received.Location;
import cn.aposoft.wechat.mp.message.template.received.Media;
import cn.aposoft.wechat.mp.message.template.received.Picture;
import cn.aposoft.wechat.mp.message.template.received.Text;
import cn.aposoft.wechat.mp.message.template.received.Video;
import cn.aposoft.wechat.mp.message.template.received.Voice;

/**
 * 微信接收消息类型集合类
 * 
 * @author Jann Liu
 * @date 2016年10月17日
 */
@XmlRootElement(namespace = "", name = "xml")
public class AposoftIntegratedMessage extends AposoftReceivedMessage //
        implements Text, Media, Picture, Voice, Video, Location, Link, //
        Event, LocationEvent, MenuEvent, QrScanEvent

{
    private static final long serialVersionUID = 8816478589951659637L;
    // 文本
    private String content;
    // 素材
    private String mediaId;
    // 图片
    private String picUrl;
    // 音频格式
    private String format;
    // 音频识别文字
    private String recognition;
    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String thumbMediaId;

    // 地理位置信息
    private String label;
    // 地理位置维度
    private String location_X;
    // 地理位置经度
    private String location_Y;
    // 地图缩放大小
    private String scale;

    // 消息标题
    private String title;
    // 消息描述
    private String description;
    // 消息链接
    private String url;
    private String eventKey;
    private String ticket;
    private String latitude;
    private String longitude;
    private String precision;
    private String event;

    // 事件消息

    /**
     * 消息标题
     * 
     * @param title
     *            消息标题
     */
    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param eventKey
     *            the eventKey to set
     */
    @XmlElement(name = "EventKey")
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    /**
     * @param ticket
     *            the ticket to set
     */
    @XmlElement(name = "Ticket")
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * @param latitude
     *            the latitude to set
     */
    @XmlElement(name = "Latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @param longitude
     *            the longitude to set
     */
    @XmlElement(name = "Longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @param precision
     *            the precision to set
     */
    @XmlElement(name = "Precision")
    public void setPrecision(String precision) {
        this.precision = precision;
    }

    /**
     * @param event
     *            the event to set
     */
    @XmlElement(name = "Event")
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * 消息描述
     * 
     * @param description
     *            消息描述
     */
    @XmlElement(name = "Description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 消息链接
     * 
     * @param url
     *            消息链接
     */
    @XmlElement(name = "Url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 地理位置信息
     * 
     * @param label
     *            地理位置信息
     */
    @XmlElement(name = "Label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 地理位置维度
     * 
     * @param location_X
     *            地理位置维度
     */
    @XmlElement(name = "Location_X")
    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    /**
     * 地理位置经度
     * 
     * @param location_Y
     *            地理位置经度
     */
    @XmlElement(name = "Location_Y")
    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    /**
     * 地图缩放大小
     * 
     * @param scale
     *            地图缩放大小
     */
    @XmlElement(name = "Scale")
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     * 
     * @param thumbMediaId
     *            视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "ThumbMediaId")
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    /**
     * 语音格式：amr
     * 
     * @param format
     *            语音格式：amr
     */
    @XmlElement(name = "Format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 语音识别结果，UTF8编码
     * 
     * @param recognition
     *            语音识别结果，UTF8编码
     */
    @XmlElement(name = "Recognition")
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    /**
     * 图片地址
     * 
     * @param picUrl
     *            图片地址
     */
    @XmlElement(name = "MediaId")
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * 
     * @param mediaId
     *            语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 文本消息内容
     * 
     * @param content
     *            文本消息内容
     */
    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 文本消息内容
     * 
     * @return the content 文本消息内容
     */
    public String getContent() {
        return content;
    }

    @Override
    public String getMediaId() {
        return mediaId;
    }

    @Override
    public String getPicUrl() {
        return picUrl;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getRecognition() {
        return recognition;
    }

    @Override
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * 地理位置信息
     */
    @Override
    public String getLabel() {
        return label;
    }

    /**
     * 地理位置维度
     */
    @Override
    public String getLocation_X() {
        return location_X;
    }

    /**
     * 地理位置经度
     */
    @Override
    public String getLocation_Y() {
        return location_Y;
    }

    /**
     * 地图缩放大小
     */
    @Override
    public String getScale() {
        return scale;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getEventKey() {
        return eventKey;
    }

    @Override
    public String getTicket() {
        return ticket;
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }

    @Override
    public String getPrecision() {
        return precision;
    }

    @Override
    public String getEvent() {
        return event;
    }

}
