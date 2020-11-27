CREATE TABLE IF NOT EXISTS my_common_dictionary
(
	`id` varchar(64) not null PRIMARY KEY COMMENT "uuid主键",
	`p_id` varchar(64) default "0" COMMENT "是否有pid 没有则为0",
	`data_type_code` varchar(50) COMMENT "数据类别编号",
	`data_type` varchar(50) COMMENT "数据类别 - 中文",
	`data_value` varchar(50) COMMENT "数据值",
	`data_text` varchar(50) COMMENT "数据文本",
	`sort_num` int(10) COMMENT "排序",
	`status` varchar(10) default 0 COMMENT "状态：0.启用，1.停用",
	`data_describe` varchar(500) COMMENT "数据描述",
	`create_time` TIMESTAMP default now() COMMENT "创建时间",
	`modify_time` datetime default now() COMMENT "修改时间"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典信息表';