-- 项目
CREATE TABLE IF NOT EXISTS `t_project`(
    `project_id` bigint auto_increment comment '项目ID',
    `project_name` varchar(50) not null comment '项目名称',
    `project_desc` varchar(250) comment '项目描述',
    `project_owner` varchar(50) not null comment '项目负责人',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
    primary key(`project_id`),
    unique key `pm` (`project_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- 精准测试
-- 类
CREATE TABLE IF NOT EXISTS `t_asm_obj`(
    `asm_obj_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `is_cotroller` int default 0 not null comment '是否是controller类， 0 不是，1 是',
    `asm_obj_name` varchar(250) not null comment '类名',
    `asm_obj_fullname` varchar(250) not null comment '类名全路径',
    `asm_obj_file_path` varchar(250) not null comment 'class 类文件路径',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
    primary key(`asm_obj_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 注解
CREATE TABLE IF NOT EXISTS `t_asm_annotation`(
    `asm_anno_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `asm_annotation_name` varchar(250) not null comment '注解的名字',
    `asm_annotation_key` varchar(50) comment 'key值',
    `asm_annotation_value` varchar(250) not null comment 'value值',
    `is_path` int default 0 not null comment '是否为uri 路径 0不是路径， 1是路径',
    `asm_annotation_type` int default 0 not null comment '0 是方法， 1是类 2是 字段',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
    primary key(`asm_anno_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 方法
CREATE TABLE IF NOT EXISTS `t_asm_method`(
    `asm_method_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `asm_method_name` varchar(250) not null comment '方法名',
    `asm_method_param_type` int default 0 comment '方法的参数, 0 为空， 1为基本类型， 2为复杂类型',
    `asm_method_param_name` varchar(250) comment '参数名',
    `asm_method_return` varchar(250) comment '返回值',
    `asm_obj_id` bigint not null comment '记录这个方法属于哪个类',
    `is_static` int not null default 0 comment '是否是静态方法',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
   primary key(`asm_method_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 字段
CREATE TABLE IF NOT EXISTS `t_asm_field`(
   `asm_field_id` bigint auto_increment comment '字段ID',
   `project_id` bigint not null comment '项目',
   `asm_obj_id` bigint not null comment '记录这个字段属于哪个类',
   `asm_field_name` varchar(250) not null comment '字段名',
    `is_static` int default 0 not null comment '是否是静态变量',
   `created_time` datetime comment '创建时间',
   `updated_time` datetime comment '更新时间',
   primary key(`asm_field_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 类和注解的对应关系
CREATE TABLE IF NOT EXISTS `t_asm_obj_annotation`(
   `asm_obj_anno_id` bigint auto_increment comment 'ID',
   `project_id` bigint not null comment '项目',
   `asm_obj_id` bigint comment '类 ID',
   `asm_anno_id` bigint comment '注释ID',
   `created_time` datetime comment '创建时间',
   `updated_time` datetime comment '更新时间',
   primary key(`asm_obj_anno_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 方法和注解的关系
CREATE TABLE IF NOT EXISTS `t_asm_method_anno`(
    `asm_method_anno_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `asm_method_id` bigint comment '类 ID',
    `asm_anno_id` bigint comment '注释ID',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
    primary key(`asm_method_anno_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 类 ID 对应关系
CREATE TABLE IF NOT EXISTS `t_asm_obj_mapping`(
    `t_asm_obj_mapping_id` bigint auto_increment comment 'ID',
    `t_left_obj_id` bigint comment '类ID',
    `t_right_obj_id` bigint comment '类ID',
    primary key(`t_asm_obj_mapping_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


