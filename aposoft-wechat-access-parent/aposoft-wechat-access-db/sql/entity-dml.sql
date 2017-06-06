create user 'wechat_test'@'localhost' identified by 'test_pass';
grant all privileges on wechat_dev.* to 'wechat_test'@'localhost';

CREATE TABLE `access_token` (
  `account_type` varchar(10) NOT NULL COMMENT '账号类型:  公众号,服务号MP,企业号 CORP',
  `id` varchar(40) NOT NULL COMMENT '公众号,服务号,企业号id',
  `agent_id` varchar(45) DEFAULT NULL COMMENT '企业号机构id',
  `access_token` varchar(512) DEFAULT NULL COMMENT '访问授权码',
  `expires_in` int(11) DEFAULT NULL COMMENT '过期周期',
  `refresh_time` datetime DEFAULT NULL COMMENT '刷新时间',
  KEY `access_token_account_index` (`id`,`account_type`,`agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ACCESS_TOKEN缓存表';


CREATE TABLE `access_config` (
  `account_type` varchar(10) NOT NULL COMMENT '账户类型',
  `id` varchar(45) NOT NULL COMMENT '公众号,服务号,企业号id',
  `agent_id` int(11) DEFAULT NULL COMMENT '企业应用id,公众号,服务号无此项',
  `access_token_secret` varchar(45) NOT NULL COMMENT '密钥用于获取access_token',
  `aes_key` varchar(45) DEFAULT NULL COMMENT 'aes加密key',
  `callback_token` varchar(45) DEFAULT NULL COMMENT '回调Token',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `access_config` (`id`,`account_type`,`agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公众号,服务号,企业号访问配置';
