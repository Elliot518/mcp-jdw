-- category

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `parent_id` int(11) DEFAULT NULL COMMENT '父类ID',
    `name` varchar(30) DEFAULT NULL COMMENT '名称',
    `cn_name` varchar(50) DEFAULT NULL COMMENT '中文名',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4;


-- module_info

DROP TABLE IF EXISTS `module_info`;

CREATE TABLE `module_info` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL COMMENT '模块程序名',
    `cn_name` varchar(50) DEFAULT NULL COMMENT '模块中文名',
    `description` varchar(255) DEFAULT NULL COMMENT '模块解释',
    `category_id` int(11) DEFAULT NULL COMMENT 'FK 所属类别id',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4;
