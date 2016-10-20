/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.AccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AccessTokenResp;
import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;

/**
 * AccessToken 默认访问服务
 * 
 * @author LiuJian
 * @date 2016年10月12日
 */
public class BasicAccessTokenService implements AccessTokenService {
    private static final Logger logger = LoggerFactory.getLogger(BasicAccessTokenService.class);

    public BasicAccessTokenService(AccessTokenClient client) {
        this.client = client;
    }

    private volatile Object lockObj = new Object();

    // 远程访问的客户端
    private AccessTokenClient client;

    //
    private volatile AccessToken accessToken;

    /**
     * 获取AccessToken
     * 
     * @return 当获取远程AccessToken失败时,返回null,获取成功则返回{@link AccessToken}
     */
    @Override
    public AccessToken getAccessToken() {
        //
        if (accessToken == null || isNearlyExpired(accessToken)) {
            acquireAccessToken();
        }
        return accessToken;
    }

    // 后台读取微信服务器的AccessToken
    private void acquireAccessToken() {
        synchronized (lockObj) {
            if (accessToken == null || isNearlyExpired(accessToken)) {
                // 正确读取TOKEN则返回，否则重试3次
                for (int i = 0; i < 3; i++) {
                    try {
                        Date refreshTime = new Date();
                        AccessTokenResp resp = client.getAccessToken(WechatMpConfigFactory.getConfig());
                        if (resp != null) {
                            if (StringUtils.isNotBlank(resp.getAccess_token()) && resp.getExpires_in() != null) {
                                BasicAccessToken token = new BasicAccessToken();
                                token.setAccess_token(resp.getAccess_token());
                                token.setExpires_in(resp.getExpires_in());
                                token.setRefreshTime(refreshTime);
                                this.accessToken = token;
                                break;
                            } else {
                                logger.error(
                                        "wechat access_token, the response is error. code:" + resp.getErrcode() + ",message:" + resp.getErrmsg());
                            }
                        }
                        logger.error("wechat access_token, the response message is empty.");
                    } catch (RemoteException e) {
                        logger.error("acquire wechat access_token error.", e);
                    }
                }
            }
        }
    }

    // 判定 access token 是否接近过期
    private boolean isNearlyExpired(AccessToken accessToken) {
        long curr = System.currentTimeMillis();
        long refreshTime = accessToken.getRefreshTime().getTime();
        if (accessToken.getExpires_in() - (curr - refreshTime) / 1000 < WechatMpConfigFactory.getConfig().getExpiredThreshold()) {
            logger.debug("remain time:" + (curr - refreshTime) / 1000);
            return true;
        }
        return false;
    }

}
