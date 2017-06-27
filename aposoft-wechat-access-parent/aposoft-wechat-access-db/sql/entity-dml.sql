create user 'wechat_test'@'localhost' identified by 'wechat_test';
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
