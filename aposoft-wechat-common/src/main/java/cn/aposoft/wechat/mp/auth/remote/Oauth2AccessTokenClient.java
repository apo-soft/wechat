package cn.aposoft.wechat.mp.auth.remote;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.config.UrlConstant;
import cn.aposoft.wechat.mp.config.WechatMpConfig;
import cn.aposoft.wechat.mp.constant.Lexical;
import cn.aposoft.wechat.mp.util.HttpClient;
import cn.aposoft.wechat.mp.util.HttpClientFactory;
import cn.aposoft.wechat.mp.util.RemoteException;

public class Oauth2AccessTokenClient implements Closeable {
    final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

    public Oauth2AccessTokenResp getOauth2Token(String code, WechatMpConfig config) throws RemoteException {
        final String requestUrl = getAccessTokenUrl(code, config);
        HttpGet httpGet = new HttpGet(requestUrl);
        String respMsg = HttpClient.execute(httpGet, httpClient);
        if (!StringUtils.isBlank(respMsg)) {
            Oauth2AccessTokenResp resp = JSON.parseObject(respMsg, Oauth2AccessTokenResp.class);
            return resp;
        } else {
            throw new RemoteException("empty response message: ");
        }
    }

    private String getAccessTokenUrl(String code, WechatMpConfig config) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("appid", config.getAppId()));
        params.add(new BasicNameValuePair("secret", config.getAppSecret()));
        params.add(new BasicNameValuePair("code", config.getAppSecret()));
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));

        String paramsUrl = URLEncodedUtils.format(params, Lexical.UTF8);
        final String requestUrl = UrlConstant.OAUTH2_ACCESS_TOKEN_URL + paramsUrl;
        return requestUrl;
    }

    @Override
    public void close() throws IOException {
        HttpClientUtils.closeQuietly(httpClient);
    }

}
