-- 创建account_config的table
-- 本表内容较小,预计会全缓存在数据库内存区,因此索引作为查找项并无实际意义
USE wechat_dev;

DROP TABLE IF EXISTS `account_config`;

CREATE TABLE `account_config` (
  `id` varchar(45) NOT NULL COMMENT '公众号,服务号,企业号id',
  `account_type` varchar(10) NOT NULL COMMENT '账户类型',
  `agent_id` int DEFAULT NULL COMMENT '企业应用id,公众号,服务号无此项',
  `secret` varchar(45) NOT NULL COMMENT '密钥用于获取access_token',
  `encoding_AES_Key` varchar(45) DEFAULT NULL COMMENT 'aes加密key',
  `token` varchar(45) DEFAULT NULL COMMENT '回调Token',
  `user_id` varchar(45) DEFAULT NULL COMMENT '公众号用户USER_ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `pk_access_config` (`id`,`account_type`,`agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公众号,服务号,企业号访问配置';