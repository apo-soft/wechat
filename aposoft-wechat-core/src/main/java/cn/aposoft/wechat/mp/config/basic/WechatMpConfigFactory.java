/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.config.basic;

import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * @author LiuJian
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
