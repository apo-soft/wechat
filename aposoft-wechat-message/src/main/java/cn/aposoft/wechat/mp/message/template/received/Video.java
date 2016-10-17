/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface Video extends Media {
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     * 
     * @return 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    public String getThumbMediaId();
}
