/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.event;

import cn.aposoft.wechat.mp.message.template.Message;

/**
 * 事件
 * 
 * @author LiuJian
 * @date 2016年10月18日
 * 
 */
public interface Event extends Message {

    /**
     * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
     * 
     * @return 事件类型 ，subscribe(订阅)、unsubscribe(取消订阅)
     */
    public String getEvent();
}
