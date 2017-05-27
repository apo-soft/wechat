/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.config.testaccount;

import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class WechatMpConfigFactory {
    private static WechatMpConfig config = new BasicWechatMpConfig();

    /**
     * 微信公众号配置信息
     * 
     * @return 微信公众号配置信息
     */
    public static WechatMpConfig getConfig() {
        return config;
    }
}
