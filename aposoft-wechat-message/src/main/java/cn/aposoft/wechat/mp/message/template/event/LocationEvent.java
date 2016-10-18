/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.event;

/**
 * 地理位置事件
 * 
 * @author LiuJian
 * @date 2016年10月18日
 * 
 */
public interface LocationEvent extends Event {
    /**
     * 地理位置纬度
     */
    String getLatitude();

    /**
     * 地理位置经度
     */
    String getLongitude();

    /**
     * 地理位置精度
     */
    String getPrecision();
}
