/**
 * Copyright  :  www.aposoft.cn
 */
package cn.aposoft.util;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

/**
 *
 * 
 * <br />
 * 
 * @date 2016年8月28日
 * 
 * @author LiuJian
 *
 */
public class HttpClientFactory {

    public static final CloseableHttpClient createDefault() {
        return HttpClients.custom().setMaxConnPerRoute(200).setMaxConnTotal(200).build();
    }

    /**
     * 创建完全信任的安全套接字客户端
     * 
     * @return {@link CloseableHttpClient}
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static final CloseableHttpClient createSSLFullTrusted() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        final SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();

        return HttpClients.custom().setSSLContext(sslContext).setMaxConnPerRoute(200).setMaxConnTotal(200)
                .setConnectionManager(new PoolingHttpClientConnectionManager(
                        RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE)
                                .register("https", new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)).build()))
                .build();
    }

}
