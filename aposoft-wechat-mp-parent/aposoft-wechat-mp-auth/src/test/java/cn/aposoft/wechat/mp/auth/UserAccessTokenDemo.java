/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.config.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenClient;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenResp;

/**
 * @author Jann Liu
 * @date 2016年10月15日
 * 
 */
public class UserAccessTokenDemo {

    /**
     * @param args
     * @throws RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        try (Oauth2AccessTokenClient client = new Oauth2AccessTokenClient();) {
            // 刷新ACCESS_TOKEN
            Oauth2AccessTokenResp resp = client.refreshAccessToken(
                    "B86yR4V-Vqdf2HuexQES6YyDLOWGICDRb_4mcaLvCKpNBl2dJkjsx2ceulL_LU8QRcj_kpfD_yenwj0srZVulQpfVULZIxZPermnSNxmyzY",
                    WechatMpConfigFactory.getConfig());
            System.out.println(JSON.toJSONString(resp));
        }
    }

}
