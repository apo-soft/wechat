package cn.aposoft.wechat.mp.config.basic;

import cn.aposoft.wechat.mp.config.WechatMpConfig;

public class BasicWechatMpConfig implements WechatMpConfig {

    @Override
    public String getUserId() {
        return "gh_0f504b63df22";
    }

    @Override
    public String getAppId() {
        return "wx31659662068251dc";
    }

    @Override
    public String getAppSecret() {
        return "9cf9858af4718fde40d67968b5de3967";
    }

    @Override
    public String getToken() {
        return "AposoftBugs";
    }

    @Override
    public int getExpiredThreshold() {
        return 300;// Token 超时时间，5分钟
    }

}
