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
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


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
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 注解
CREATE TABLE IF NOT EXISTS `t_asm_annotation`(
    `asm_anno_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `asm_obj_id` bigint not null comment 'controller 类名称',
    `asm_obj_name` varchar(100) not null comment '类名',
    `asm_method_type` varchar(250) not null comment '请求的方式',
    `asm_path` varchar(250) not null comment '请求的路由',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
    primary key(`asm_anno_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 方法
CREATE TABLE IF NOT EXISTS `t_asm_method`(
    `asm_method_id` bigint auto_increment comment 'ID',
    `project_id` bigint not null comment '项目',
    `asm_method_name` varchar(250) not null comment '方法名',
    `asm_obj_id` bigint not null comment '记录这个方法属于哪个类',
    `asm_obj_name` varchar(100) not null comment '类名称',
    `is_static` int default 0 comment '是否是静态方法',
    `created_time` datetime comment '创建时间',
    `updated_time` datetime comment '更新时间',
   primary key(`asm_method_id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 字段
CREATE TABLE IF NOT EXISTS `t_asm_field`(
   `asm_field_id` bigint auto_increment comment '字段ID',
   `project_id` bigint not null comment '项目',
   `asm_obj_id` bigint not null comment '记录这个字段属于哪个类',
   `asm_obj_name` varchar(100) comment '冗余类名',
   `asm_field_name` varchar(250) not null comment '字段名',
   `is_static` int default 0 not null comment '是否是静态变量',
   `created_time` datetime comment '创建时间',
   `updated_time` datetime comment '更新时间',
   primary key(`asm_field_id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 类 ID 对应关系
CREATE TABLE IF NOT EXISTS `t_asm_obj_mapping`(
    `t_asm_obj_mapping_id` bigint auto_increment comment 'ID',
    `t_controller_obj_id` bigint comment '类ID',
    `t_other_obj_id` bigint comment '类ID',
    `t_other_obj_method_id` bigint comment '类方法ID',
    primary key(`t_asm_obj_mapping_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


