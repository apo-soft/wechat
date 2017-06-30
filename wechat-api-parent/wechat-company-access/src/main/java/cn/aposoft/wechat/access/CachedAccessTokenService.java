package cn.aposoft.wechat.access;

import cn.aposoft.framework.concurrent.SelfRefreshWorker;

public interface CachedAccessTokenService extends CompanyAccessTokenAccess, SelfRefreshWorker {

}