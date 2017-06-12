/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * @author Jann Liu
 * @date 2016年10月17日
 * 
 */
public interface Location extends ReceivedMessage {

    /**
     * 位置信息
     * 
     * @return 位置信息
     */
    public String getLabel();

    /**
     * 23.134521
     * 
     * @return 纬度
     */
    public String getLocation_X();

    /**
     * 113.358803
     * 
     * @return 经度
     */
    public String getLocation_Y();

    /**
     * 地图缩放大小
     * 
     * @return 地图缩放大小
     */
    public String getScale();
}
