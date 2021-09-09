-- 测试用例
CREATE TABLE IF NOT EXISTS `t_case`(
`case_id` bigint auto_increment comment '测试用例ID',
`case_name` varchar(20) not null comment '用例名称',
`case_des` varchar(250) comment '用例描述',
`project_id` bigint not null comment '项目',
`case_owner` varchar(250) comment '维护人',
`case_type` int default 0 not null comment '类型， 0 - 前端， 1- api 2 - rpc',
`end_conf_id` bigint comment '是否有 前端 配置',
`api_conf_id` bigint comment '是否有 api 配置',
`rpc_conf_id` bigint comment '是否有 rpc 配置',
`created_time` datetime comment '创建时间',
`updated_time` datetime comment '更新时间',
primary key(`case_id`),
unique key cn (`case_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 前端测试
CREATE TABLE IF NOT EXISTS `t_end_conf`(
`t_end_conf_id` bigint auto_increment comment 'ID',
`project_id` bigint not null comment '项目',
`t_end_conf_name` varchar(250) comment '前端配置名称',
`end_browser` int default 0 not null comment '浏览器类型 0-谷歌 1-火狐 2-IE',
`created_time` datetime comment '创建时间',
`updated_time` datetime comment '更新时间',
primary key(`t_end_conf_id`),
unique key ec (`t_end_conf_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- api 测试
-- CREATE TABLE IF NOT EXISTS `t_api_conf`(
--     `t_api_conf_id` bigint auto_increment comment 'ID',
--     `project_id` bigint not null comment '项目',
--     `created_time` datetime comment '创建时间',
--     `updated_time` datetime comment '更新时间',
--     primary key(`t_api_conf_id`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpc 测试
CREATE TABLE IF NOT EXISTS `t_rpc_conf`(
`t_rpc_conf_id` bigint auto_increment comment 'ID',
`t_rpc_conf_name` varchar(100) not null comment 'rpc 配置名称',
`project_id` bigint not null comment '项目',
`application_name` varchar(100) not null comment '应用名称',
`zk_address` varchar(200) not null comment 'zk地址',
`reference_version` varchar(20) not null default '1.0.0' comment '版本',
`reference_group` varchar(20) not null default 'dubbo' comment '组别',
`created_time` datetime comment '创建时间',
`updated_time` datetime comment '更新时间',
primary key(`t_rpc_conf_id`),
unique key rc (`t_rpc_conf_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;