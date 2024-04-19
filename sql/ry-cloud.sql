DROP DATABASE IF EXISTS `ry-cloud`;

CREATE DATABASE  `ry-cloud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `ry-cloud`;

-- ----------------------------
-- Table structure for base_achievement_type
-- ----------------------------
DROP TABLE IF EXISTS `base_achievement_type`;
CREATE TABLE `base_achievement_type`  (
  `achievement_type_id` bigint NOT NULL COMMENT '成果类型id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户编号',
  `achievement_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果类型名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '成果类型状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`achievement_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '成果类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_achievement_type
-- ----------------------------
INSERT INTO `base_achievement_type` VALUES (1780827338343714817, '000000', '学术论文', '0', '0', 100, 1, '2024-04-18 13:14:58', 1, '2024-04-18 13:18:21', '学术论文是某一学术课题，在实验性、理论性或预测性上具有的新的科学研究成果或创新见解和知识的科学记录 ，或是某种已知原理应用于实际上取得新进展的科学总结，用以提供学术会议上宣读、交流、讨论或学术刊物上发表，或用作其他用途的书面文件。');
INSERT INTO `base_achievement_type` VALUES (1780828579203387393, '000000', '科研项目', '0', '0', 100, 1, '2024-04-18 13:19:54', 1, '2024-04-18 13:20:19', '科研项目指国家各级政府支持的纵向科研项目（课题）、来自于企事业单位的横向科研合作开发项目（课题）和学院自筹科研项目（课题）。科研项目又可分为纵向科研项目和横向科研项目两种。纵向科研项目是指：科技部、国家自然科学基金委、国家社科规划办、教育部、省科技厅、省社科规划办、省教育厅、市科技局等政府科研主管部门批准立项的各类科学研究项目。横向科研项目是指由其他政府部门（含国家部委、省市部门）、企事业单位、公司、团体或个人委托我校教学科研单位或教师进行研究或协作研究的各类课题，包括国际间企业合作项目。');
INSERT INTO `base_achievement_type` VALUES (1780829767541985282, '000000', '专著或编著', '0', '0', 100, 1, '2024-04-18 13:24:37', 1, '2024-04-18 13:26:22', '专著是指研究有一定的难度，学术上有新的突破，有较多独创的学术成果，对本学科的发展有较好的指导作用。编著是指在总结归纳他人研究成果的基础上，有自己的观点和见解，至少有1/3属作者自己的有新意的著述，对本学科的发展有较大的参考价值。');
INSERT INTO `base_achievement_type` VALUES (1780830750233858050, '000000', '专利或软件著作权', '0', '0', 100, 1, '2024-04-18 13:28:32', 1, '2024-04-18 13:29:54', '专利是受法律规范保护的发明创造，是指一项发明创造向国家审批机关提出专利申请，经依法审查合格后向专利申请人授予的在规定的时间内对该项发明创造享有的专有权。计算机软件著作权是指自然人、法人或其他组织对计算机软件作品享有的财产权利和精神权利的总称，软件著作权主要是备案制。');

-- ----------------------------
-- Table structure for base_competition_type
-- ----------------------------
DROP TABLE IF EXISTS `base_competition_type`;
CREATE TABLE `base_competition_type`  (
  `competition_type_id` bigint NOT NULL COMMENT '竞赛类型id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户编号',
  `competition_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '竞赛类型名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '竞赛类型状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`competition_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '竞赛类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_competition_type
-- ----------------------------
INSERT INTO `base_competition_type` VALUES (1780833625475387394, '000000', '中国“互联网+”大学生创新创业大赛', '0', '0', 100, 1, '2024-04-18 13:39:57', 1, '2024-04-18 13:39:57', NULL);
INSERT INTO `base_competition_type` VALUES (1780834120474562561, '000000', '“挑战杯”全国大学生竞赛', '0', '0', 100, 1, '2024-04-18 13:41:55', 1, '2024-04-18 13:52:22', '包括“挑战杯”全国大学生课外学术科技作品竞赛以及“挑战杯”全国大学生创业计划大赛。');
INSERT INTO `base_competition_type` VALUES (1780834190951452674, '000000', 'ACM-ICPC国际大学生程序设计竞赛', '0', '0', 100, 1, '2024-04-18 13:42:12', 1, '2024-04-18 13:42:12', NULL);
INSERT INTO `base_competition_type` VALUES (1780834229119619073, '000000', '全国大学生数学建模竞赛', '0', '0', 100, 1, '2024-04-18 13:42:21', 1, '2024-04-18 13:42:21', NULL);
INSERT INTO `base_competition_type` VALUES (1780834267552026626, '000000', '全国大学生电子设计竞赛', '0', '0', 100, 1, '2024-04-18 13:42:30', 1, '2024-04-18 13:42:30', NULL);
INSERT INTO `base_competition_type` VALUES (1780834368836079618, '000000', '全国大学生机械创新设计大赛', '0', '0', 100, 1, '2024-04-18 13:42:54', 1, '2024-04-18 13:42:54', NULL);
INSERT INTO `base_competition_type` VALUES (1780834469298049025, '000000', '全国大学生电子商务“创新、创意及创业”挑战赛', '0', '0', 100, 1, '2024-04-18 13:43:18', 1, '2024-04-18 13:43:18', NULL);
INSERT INTO `base_competition_type` VALUES (1780834531344388098, '000000', '全国大学生物流设计大赛', '0', '0', 100, 1, '2024-04-18 13:43:33', 1, '2024-04-18 13:43:33', NULL);
INSERT INTO `base_competition_type` VALUES (1780834595353661442, '000000', '外研社全国大学生英语系列赛', '0', '0', 100, 1, '2024-04-18 13:43:49', 1, '2024-04-18 13:43:49', NULL);
INSERT INTO `base_competition_type` VALUES (1780834687162781697, '000000', '全国大学生机器人大赛', '0', '0', 100, 1, '2024-04-18 13:44:10', 1, '2024-04-18 13:44:10', NULL);
INSERT INTO `base_competition_type` VALUES (1780834778414059521, '000000', '中国大学生计算机设计大赛', '0', '0', 100, 1, '2024-04-18 13:44:32', 1, '2024-04-18 13:44:32', NULL);
INSERT INTO `base_competition_type` VALUES (1780834885196845057, '000000', '中国高校计算机大赛', '0', '0', 100, 1, '2024-04-18 13:44:58', 1, '2024-04-18 13:52:13', '包括大数据挑战赛、团体程序设计天梯赛、移动应用创新赛、网络技术挑战赛以及人工智能创意赛');
INSERT INTO `base_competition_type` VALUES (1780834935184560130, '000000', '蓝桥杯全国软件和信息技术专业人才大赛', '0', '0', 100, 1, '2024-04-18 13:45:10', 1, '2024-04-18 13:45:10', NULL);

-- ----------------------------
-- Table structure for base_honor_type
-- ----------------------------
DROP TABLE IF EXISTS `base_honor_type`;
CREATE TABLE `base_honor_type`  (
  `honor_type_id` bigint UNSIGNED NOT NULL COMMENT '荣誉类型id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户编号',
  `honor_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '荣誉类型名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '荣誉类型状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`honor_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '荣誉类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_honor_type
-- ----------------------------
INSERT INTO `base_honor_type` VALUES (1780835777111396354, '000000', '国家奖学金', '0', '0', 100, 1, '2024-04-18 13:48:30', 1, '2024-04-18 13:48:30', NULL);
INSERT INTO `base_honor_type` VALUES (1780836199691718657, '000000', '学校奖学金', '0', '0', 100, 1, '2024-04-18 13:50:11', 1, '2024-04-18 13:50:24', '包括特等奖、一等奖、二等奖以及三等奖');
INSERT INTO `base_honor_type` VALUES (1780836855429206017, '000000', '专项奖学金', '0', '0', 100, 1, '2024-04-18 13:52:47', 1, '2024-04-18 13:52:47', NULL);
INSERT INTO `base_honor_type` VALUES (1780836914904436737, '000000', '三好学生', '0', '0', 100, 1, '2024-04-18 13:53:02', 1, '2024-04-18 13:53:02', NULL);
INSERT INTO `base_honor_type` VALUES (1780836959397613570, '000000', '优秀学生干部', '0', '0', 100, 1, '2024-04-18 13:53:12', 1, '2024-04-18 13:53:12', NULL);
INSERT INTO `base_honor_type` VALUES (1780837013269254145, '000000', '优秀共青团员', '0', '0', 100, 1, '2024-04-18 13:53:25', 1, '2024-04-18 13:53:25', NULL);
INSERT INTO `base_honor_type` VALUES (1780837065744191490, '000000', '优秀共青团干部', '0', '0', 100, 1, '2024-04-18 13:53:37', 1, '2024-04-18 13:53:37', NULL);
INSERT INTO `base_honor_type` VALUES (1780837131607347202, '000000', '优秀毕业生', '0', '0', 100, 1, '2024-04-18 13:53:53', 1, '2024-04-18 13:53:53', NULL);
INSERT INTO `base_honor_type` VALUES (1780838123023372289, '000000', '学生协会优秀干部', '0', '0', 100, 1, '2024-04-18 13:57:50', 1, '2024-04-18 14:03:31', '学校认可的校组织或社团所授予的荣誉称号');

-- ----------------------------
-- Table structure for business_achievement
-- ----------------------------
DROP TABLE IF EXISTS `business_achievement`;
CREATE TABLE `business_achievement`  (
  `achievement_id` bigint NOT NULL COMMENT '成果id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户编号',
  `achievement_type_id` bigint NULL DEFAULT NULL COMMENT '成果类型id',
  `achievement_student_id` bigint NULL DEFAULT NULL COMMENT '成果第一作者id',
  `achievement_teacher_id` bigint NULL DEFAULT NULL COMMENT '成果第一指导老师id',
  `achievement_other_student_ids` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果其他作者id JSON',
  `achievement_other_teacher_ids` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果其他指导老师id JSON',
  `achievement_evidence_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果作证材料URL',
  `achievement_feedback` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果审核反馈',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '成果状态（0待审核 1审核通过 2审核不通过）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`achievement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_achievement
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint NOT NULL COMMENT '编号',
  `data_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '数据源名称',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (1779863641857204226, 'master', 't_achievement', '成果类型表', NULL, NULL, 'Achievement', 'crud', 'top.sharehome.base', 'base', 'achievement', '成果类型', 'AntonyCheng', '0', '/', '{\"treeCode\":null,\"treeName\":null,\"treeParentCode\":null,\"parentMenuId\":\"1\"}', 100, 1, '2024-04-15 21:16:36', 1, '2024-04-15 21:52:37', NULL);
INSERT INTO `gen_table` VALUES (1779863642075308034, 'master', 't_competition', '竞赛类型表', NULL, NULL, 'Competition', 'crud', 'top.sharehome.base', 'base', 'competition', '竞赛类型', 'AntonyCheng', '0', '/', '{\"treeCode\":null,\"treeName\":null,\"treeParentCode\":null,\"parentMenuId\":\"1\"}', 100, 1, '2024-04-15 21:16:44', 1, '2024-04-15 22:01:27', NULL);
INSERT INTO `gen_table` VALUES (1779863642209525762, 'master', 't_honor', '荣誉类型表', NULL, NULL, 'Honor', 'crud', 'top.sharehome.base', 'base', 'honor', '荣誉类型', 'AntonyCheng', '0', '/', '{\"treeCode\":null,\"treeName\":null,\"treeParentCode\":null,\"parentMenuId\":\"1\"}', 100, 1, '2024-04-15 21:16:49', 1, '2024-04-15 22:11:32', NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint NOT NULL COMMENT '编号',
  `table_id` bigint NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1779863641945284609, 1779863641857204226, 'achievement_id', '成果id', 'bigint', 'Long', 'achievementId', '1', '0', '1', NULL, '1', '1', NULL, 'EQ', 'input', '', 1, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863641945284610, 1779863641857204226, 'achievement_name', '成果名称', 'varchar(255)', 'String', 'achievementName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863641945284611, 1779863641857204226, 'status', '成果状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', 'sys_normal_disable', 4, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199169, 1779863641857204226, 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 5, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199170, 1779863641857204226, 'create_dept', '创建部门', 'bigint', 'Long', 'createDept', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 6, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199171, 1779863641857204226, 'create_by', '创建者', 'bigint', 'Long', 'createBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 7, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199172, 1779863641857204226, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '0', NULL, NULL, '1', '0', 'EQ', 'datetime', '', 8, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199173, 1779863641857204226, 'update_by', '更新者', 'bigint', 'Long', 'updateBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 9, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642008199174, 1779863641857204226, 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', '0', NULL, NULL, '1', NULL, 'EQ', 'datetime', '', 10, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779863642142416898, 1779863642075308034, 'competition_id', '竞赛id', 'bigint', 'Long', 'competitionId', '1', '0', '1', NULL, '1', '1', NULL, 'EQ', 'input', '', 1, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416899, 1779863642075308034, 'competition_name', '竞赛名称', 'varchar(255)', 'String', 'competitionName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416900, 1779863642075308034, 'status', '竞赛状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', 'sys_normal_disable', 4, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416901, 1779863642075308034, 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 5, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416902, 1779863642075308034, 'create_dept', '创建部门', 'bigint', 'Long', 'createDept', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 6, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416903, 1779863642075308034, 'create_by', '创建者', 'bigint', 'Long', 'createBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 7, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416904, 1779863642075308034, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '0', NULL, NULL, '1', NULL, 'EQ', 'datetime', '', 8, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416905, 1779863642075308034, 'update_by', '更新者', 'bigint', 'Long', 'updateBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 9, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642142416906, 1779863642075308034, 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', '0', NULL, NULL, '1', NULL, 'EQ', 'datetime', '', 10, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779863642209525763, 1779863642209525762, 'honor_id', '荣誉id', 'bigint', 'Long', 'honorId', '1', '0', '1', NULL, '1', '1', NULL, 'EQ', 'input', '', 1, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634626, 1779863642209525762, 'honor_name', '荣誉名称', 'varchar(255)', 'String', 'honorName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634627, 1779863642209525762, 'status', '荣誉状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', 'sys_normal_disable', 4, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634628, 1779863642209525762, 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 5, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634629, 1779863642209525762, 'create_dept', '创建部门', 'bigint', 'Long', 'createDept', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 6, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634630, 1779863642209525762, 'create_by', '创建者', 'bigint', 'Long', 'createBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 7, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634631, 1779863642209525762, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '0', NULL, NULL, '1', NULL, 'EQ', 'datetime', '', 8, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634632, 1779863642209525762, 'update_by', '更新者', 'bigint', 'Long', 'updateBy', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 9, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779863642276634633, 1779863642209525762, 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', '0', NULL, NULL, '1', NULL, 'EQ', 'datetime', '', 10, 100, 1, '2024-04-15 21:25:35', 1, '2024-04-15 22:11:32');
INSERT INTO `gen_table_column` VALUES (1779869811271540738, 1779863641857204226, 'tenant_id', '租户编号', 'varchar(20)', 'String', 'tenantId', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 2, 100, 1, '2024-04-15 21:50:06', 1, '2024-04-15 21:52:37');
INSERT INTO `gen_table_column` VALUES (1779869825280516097, 1779863642075308034, 'tenant_id', '租户编号', 'varchar(20)', 'String', 'tenantId', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 2, 100, 1, '2024-04-15 21:50:09', 1, '2024-04-15 22:01:27');
INSERT INTO `gen_table_column` VALUES (1779869833094504450, 1779863642209525762, 'tenant_id', '租户编号', 'varchar(20)', 'String', 'tenantId', '0', '0', '0', NULL, NULL, NULL, NULL, 'EQ', 'input', '', 2, 100, 1, '2024-04-15 21:50:11', 1, '2024-04-15 22:11:32');

-- ----------------------------
-- Table structure for sys_client
-- ----------------------------
DROP TABLE IF EXISTS `sys_client`;
CREATE TABLE `sys_client`  (
  `id` bigint NOT NULL COMMENT 'id',
  `client_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id',
  `client_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端key',
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端秘钥',
  `grant_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权类型',
  `device_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备类型',
  `active_timeout` int NULL DEFAULT 1800 COMMENT 'token活跃超时时间',
  `timeout` int NULL DEFAULT 604800 COMMENT 'token固定超时',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统授权表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_client
-- ----------------------------
INSERT INTO `sys_client` VALUES (1, 'e5cd7e4891bf95d1d19206ce24a7b32e', 'pc', 'pc123', 'password,social', 'pc', 1800, 604800, '0', '0', 103, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40');
INSERT INTO `sys_client` VALUES (2, '428a8310cd442757ae699df5d894f051', 'app', 'app123', 'password,sms,social', 'android', 1800, 604800, '0', '0', 103, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` bigint NOT NULL COMMENT '参数主键',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '000000', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '000000', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '000000', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (5, '000000', '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (11, '000000', 'OSS预览列表资源开关', 'sys.oss.previewListResource', 'true', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, 'true:开启, false:关闭');
INSERT INTO `sys_config` VALUES (1778327369489661972, '440965', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (1778327369489661973, '440965', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '初始化密码 123456');
INSERT INTO `sys_config` VALUES (1778327369489661974, '440965', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (1778327369489661975, '440965', '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (1778327369489661976, '440965', 'OSS预览列表资源开关', 'sys.oss.previewListResource', 'true', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', 'true:开启, false:关闭');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint NOT NULL COMMENT '部门id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` bigint NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, '000000', 0, '0', '哈尔滨商业大学', 0, 1, '17388888888', '1911111111@qq.com', '0', '0', 103, 1, '2024-04-11 15:26:39', 1, '2024-04-12 16:02:23');
INSERT INTO `sys_dept` VALUES (1778327369087008770, '440965', 0, '0', '哈尔滨XXX大学', 0, 1778327369355444226, NULL, NULL, '0', '0', 103, 1, '2024-04-11 15:40:59', 1, '2024-04-12 16:07:59');
INSERT INTO `sys_dept` VALUES (1779736001456439298, '000000', 100, '0,100', '教职工', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 12:58:23', 1, '2024-04-15 12:58:23');
INSERT INTO `sys_dept` VALUES (1779736136575942657, '000000', 100, '0,100', '在校学生', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 12:58:56', 1, '2024-04-15 12:58:56');
INSERT INTO `sys_dept` VALUES (1779736469817589762, '000000', 1779736001456439298, '0,100,1779736001456439298', '党政管理机构', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 13:00:15', 1, '2024-04-15 13:00:15');
INSERT INTO `sys_dept` VALUES (1779736606375739394, '000000', 1779736001456439298, '0,100,1779736001456439298', '教学科研机构', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 13:00:48', 1, '2024-04-15 13:00:48');
INSERT INTO `sys_dept` VALUES (1779737319176732674, '000000', 1779736469817589762, '0,100,1779736001456439298,1779736469817589762', '办公室', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 13:03:37', 1, '2024-04-15 13:03:37');
INSERT INTO `sys_dept` VALUES (1779738476230017025, '000000', 1779736606375739394, '0,100,1779736001456439298,1779736606375739394', '计算机与信息工程学院', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 13:08:13', 1, '2024-04-15 13:08:13');
INSERT INTO `sys_dept` VALUES (1779739777512833026, '000000', 1779736136575942657, '0,100,1779736136575942657', '计算机与信息工程学院', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 13:13:24', 1, '2024-04-15 13:14:46');
INSERT INTO `sys_dept` VALUES (1779758022420660225, '000000', 1779736469817589762, '0,100,1779736001456439298,1779736469817589762', '学生处', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 14:25:54', 1, '2024-04-15 14:25:54');
INSERT INTO `sys_dept` VALUES (1779758085389746177, '000000', 1779736469817589762, '0,100,1779736001456439298,1779736469817589762', '教务处', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 14:26:09', 1, '2024-04-15 14:26:09');
INSERT INTO `sys_dept` VALUES (1779759717414404097, '000000', 1779739777512833026, '0,100,1779736136575942657,1779739777512833026', '2020级', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 14:32:38', 1, '2024-04-15 14:32:38');
INSERT INTO `sys_dept` VALUES (1779759833139445761, '000000', 1779759717414404097, '0,100,1779736136575942657,1779739777512833026,1779759717414404097', '计算机科学与技术', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 14:33:05', 1, '2024-04-15 14:33:05');
INSERT INTO `sys_dept` VALUES (1779760160337100802, '000000', 1779759833139445761, '0,100,1779736136575942657,1779739777512833026,1779759717414404097,1779759833139445761', '2020级计算机科学与技术02班', 0, NULL, NULL, NULL, '0', '0', 100, 1, '2024-04-15 14:34:23', 1, '2024-04-15 14:34:23');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint NOT NULL COMMENT '字典编码',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `dict_sort` int NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, '000000', 1, '男', '0', 'sys_user_sex', '', '', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, '000000', 2, '女', '1', 'sys_user_sex', '', '', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, '000000', 3, '未知', '2', 'sys_user_sex', '', '', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, '000000', 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, '000000', 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, '000000', 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, '000000', 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (12, '000000', 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, '000000', 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, '000000', 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, '000000', 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, '000000', 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, '000000', 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, '000000', 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, '000000', 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, '000000', 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, '000000', 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, '000000', 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, '000000', 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, '000000', 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, '000000', 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, '000000', 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, '000000', 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, '000000', 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (29, '000000', 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '其他操作');
INSERT INTO `sys_dict_data` VALUES (30, '000000', 0, '密码认证', 'password', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '密码认证');
INSERT INTO `sys_dict_data` VALUES (31, '000000', 0, '短信认证', 'sms', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '短信认证');
INSERT INTO `sys_dict_data` VALUES (32, '000000', 0, '邮件认证', 'email', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '邮件认证');
INSERT INTO `sys_dict_data` VALUES (33, '000000', 0, '小程序认证', 'xcx', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '小程序认证');
INSERT INTO `sys_dict_data` VALUES (34, '000000', 0, '三方登录认证', 'social', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '三方登录认证');
INSERT INTO `sys_dict_data` VALUES (35, '000000', 0, 'PC', 'pc', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, 'PC');
INSERT INTO `sys_dict_data` VALUES (36, '000000', 0, '安卓', 'android', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '安卓');
INSERT INTO `sys_dict_data` VALUES (37, '000000', 0, 'iOS', 'ios', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, 'iOS');
INSERT INTO `sys_dict_data` VALUES (38, '000000', 0, '小程序', 'xcx', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '小程序');
INSERT INTO `sys_dict_data` VALUES (1778327369418358796, '440965', 1, '男', '0', 'sys_user_sex', '', '', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '性别男');
INSERT INTO `sys_dict_data` VALUES (1778327369418358797, '440965', 2, '女', '1', 'sys_user_sex', '', '', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '性别女');
INSERT INTO `sys_dict_data` VALUES (1778327369418358798, '440965', 3, '未知', '2', 'sys_user_sex', '', '', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '性别未知');
INSERT INTO `sys_dict_data` VALUES (1778327369418358799, '440965', 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '显示菜单');
INSERT INTO `sys_dict_data` VALUES (1778327369418358800, '440965', 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (1778327369418358801, '440965', 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '正常状态');
INSERT INTO `sys_dict_data` VALUES (1778327369418358802, '440965', 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '停用状态');
INSERT INTO `sys_dict_data` VALUES (1778327369418358803, '440965', 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '系统默认是');
INSERT INTO `sys_dict_data` VALUES (1778327369418358804, '440965', 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '系统默认否');
INSERT INTO `sys_dict_data` VALUES (1778327369418358805, '440965', 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '通知');
INSERT INTO `sys_dict_data` VALUES (1778327369418358806, '440965', 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '公告');
INSERT INTO `sys_dict_data` VALUES (1778327369418358807, '440965', 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '正常状态');
INSERT INTO `sys_dict_data` VALUES (1778327369481273346, '440965', 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '关闭状态');
INSERT INTO `sys_dict_data` VALUES (1778327369481273347, '440965', 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '新增操作');
INSERT INTO `sys_dict_data` VALUES (1778327369481273348, '440965', 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '修改操作');
INSERT INTO `sys_dict_data` VALUES (1778327369485467649, '440965', 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '删除操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661954, '440965', 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '授权操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661955, '440965', 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '导出操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661956, '440965', 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '导入操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661957, '440965', 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '强退操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661958, '440965', 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '生成操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661959, '440965', 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '清空操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661960, '440965', 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '正常状态');
INSERT INTO `sys_dict_data` VALUES (1778327369489661961, '440965', 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '停用状态');
INSERT INTO `sys_dict_data` VALUES (1778327369489661962, '440965', 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '其他操作');
INSERT INTO `sys_dict_data` VALUES (1778327369489661963, '440965', 0, '密码认证', 'password', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '密码认证');
INSERT INTO `sys_dict_data` VALUES (1778327369489661964, '440965', 0, '短信认证', 'sms', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '短信认证');
INSERT INTO `sys_dict_data` VALUES (1778327369489661965, '440965', 0, '邮件认证', 'email', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '邮件认证');
INSERT INTO `sys_dict_data` VALUES (1778327369489661966, '440965', 0, '小程序认证', 'xcx', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '小程序认证');
INSERT INTO `sys_dict_data` VALUES (1778327369489661967, '440965', 0, '三方登录认证', 'social', 'sys_grant_type', 'el-check-tag', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '三方登录认证');
INSERT INTO `sys_dict_data` VALUES (1778327369489661968, '440965', 0, 'PC', 'pc', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', 'PC');
INSERT INTO `sys_dict_data` VALUES (1778327369489661969, '440965', 0, '安卓', 'android', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '安卓');
INSERT INTO `sys_dict_data` VALUES (1778327369489661970, '440965', 0, 'iOS', 'ios', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', 'iOS');
INSERT INTO `sys_dict_data` VALUES (1778327369489661971, '440965', 0, '小程序', 'xcx', 'sys_device_type', '', 'default', 'N', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '小程序');
INSERT INTO `sys_dict_data` VALUES (1779052162635550722, '000000', 0, '2019级', '2019', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:41:03', 1, '2024-04-13 15:41:27', '2019级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779052333863817217, '000000', 1, '2020级', '2020', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:41:44', 1, '2024-04-13 15:41:44', '2020级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779052800001986562, '000000', 2, '2021级', '2021', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:43:35', 1, '2024-04-13 15:43:35', '2021级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779052883086954497, '000000', 3, '2022级', '2022', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:43:55', 1, '2024-04-13 15:43:55', '2022级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779052942692208642, '000000', 4, '2023级', '2023', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:44:09', 1, '2024-04-13 15:44:20', '2023级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779053210523684866, '000000', 5, '2024级', '2024', 'base_major_grade', '', 'default', 'N', 100, 1, '2024-04-13 15:45:13', 1, '2024-04-13 15:45:41', '2024级学生年级');
INSERT INTO `sys_dict_data` VALUES (1779054095685406721, '000000', 0, '2023届', '2023', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:48:44', 1, '2024-04-13 15:48:44', '2023届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1779054191722385410, '000000', 1, '2024届', '2024', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:49:07', 1, '2024-04-13 15:49:13', '2024届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1779054271682596866, '000000', 2, '2025届', '2025', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:49:26', 1, '2024-04-13 15:49:26', '2025届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1779054341471621122, '000000', 3, '2026届', '2026', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:49:43', 1, '2024-04-13 15:49:43', '2026届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1779054414867746818, '000000', 4, '2027届', '2027', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:50:00', 1, '2024-04-13 15:50:00', '2027届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1779054515715592194, '000000', 5, '2028届', '2028', 'base_graduation_year', '', 'default', 'N', 100, 1, '2024-04-13 15:50:24', 1, '2024-04-13 15:50:29', '2028届毕业年限');
INSERT INTO `sys_dict_data` VALUES (1781338933058727938, '000000', 0, '待审核', '0', 'business_experience_type', '', 'info', 'N', 100, 1, '2024-04-19 23:07:52', 1, '2024-04-19 23:07:52', '');
INSERT INTO `sys_dict_data` VALUES (1781339023240458242, '000000', 1, '审核通过', '1', 'business_experience_type', '', 'success', 'N', 100, 1, '2024-04-19 23:08:13', 1, '2024-04-19 23:08:13', '');
INSERT INTO `sys_dict_data` VALUES (1781339151137370114, '000000', 2, '审核未通过', '2', 'business_experience_type', '', 'danger', 'N', 100, 1, '2024-04-19 23:08:44', 1, '2024-04-19 23:08:44', '');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint NOT NULL COMMENT '字典主键',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `tenant_id`(`tenant_id` ASC, `dict_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '000000', '用户性别', 'sys_user_sex', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '000000', '菜单状态', 'sys_show_hide', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '000000', '系统开关', 'sys_normal_disable', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (6, '000000', '系统是否', 'sys_yes_no', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '000000', '通知类型', 'sys_notice_type', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '000000', '通知状态', 'sys_notice_status', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '000000', '操作类型', 'sys_oper_type', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '000000', '系统状态', 'sys_common_status', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (11, '000000', '授权类型', 'sys_grant_type', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '认证授权类型');
INSERT INTO `sys_dict_type` VALUES (12, '000000', '设备类型', 'sys_device_type', 100, 1, '2024-04-11 15:26:40', NULL, NULL, '客户端设备类型');
INSERT INTO `sys_dict_type` VALUES (1778327369418358786, '440965', '用户性别', 'sys_user_sex', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358787, '440965', '菜单状态', 'sys_show_hide', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358788, '440965', '系统开关', 'sys_normal_disable', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358789, '440965', '系统是否', 'sys_yes_no', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358790, '440965', '通知类型', 'sys_notice_type', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358791, '440965', '通知状态', 'sys_notice_status', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358792, '440965', '操作类型', 'sys_oper_type', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358793, '440965', '系统状态', 'sys_common_status', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (1778327369418358794, '440965', '授权类型', 'sys_grant_type', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '认证授权类型');
INSERT INTO `sys_dict_type` VALUES (1778327369418358795, '440965', '设备类型', 'sys_device_type', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', '客户端设备类型');
INSERT INTO `sys_dict_type` VALUES (1779051715988312066, '000000', '专业年级', 'base_major_grade', 100, 1, '2024-04-13 15:39:17', 1, '2024-04-13 15:39:55', '专业年级列表');
INSERT INTO `sys_dict_type` VALUES (1779053880463085569, '000000', '毕业年限', 'base_graduation_year', 100, 1, '2024-04-13 15:47:53', 1, '2024-04-13 15:47:53', '毕业年限列表');
INSERT INTO `sys_dict_type` VALUES (1781338693559775234, '000000', '经历状态', 'business_experience_type', 100, 1, '2024-04-19 23:06:55', 1, '2024-04-19 23:06:55', '经历状态类型');

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint NOT NULL COMMENT '访问ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `client_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '客户端',
  `device_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '设备类型',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE,
  INDEX `idx_sys_logininfor_s`(`status` ASC) USING BTREE,
  INDEX `idx_sys_logininfor_lt`(`login_time` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (1778328129312997377, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '登录成功', '2024-04-11 15:44:00');
INSERT INTO `sys_logininfor` VALUES (1778328435102924802, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '退出成功', '2024-04-11 15:45:13');
INSERT INTO `sys_logininfor` VALUES (1778328595732185089, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '登录成功', '2024-04-11 15:45:52');
INSERT INTO `sys_logininfor` VALUES (1778328662794911746, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '退出成功', '2024-04-11 15:46:08');
INSERT INTO `sys_logininfor` VALUES (1778328871390232578, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '登录成功', '2024-04-11 15:46:57');
INSERT INTO `sys_logininfor` VALUES (1778328957461544962, '440965', 'admin', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '退出成功', '2024-04-11 15:47:18');
INSERT INTO `sys_logininfor` VALUES (1778712345687216129, '440965', 'antony', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '1', '验证码错误', '2024-04-12 17:10:45');
INSERT INTO `sys_logininfor` VALUES (1778712355900346370, '440965', 'antony', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '登录成功', '2024-04-12 17:10:47');
INSERT INTO `sys_logininfor` VALUES (1778712565930119170, '440965', 'antony', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', '0', '退出成功', '2024-04-12 17:11:37');
INSERT INTO `sys_logininfor` VALUES (1779862918260154370, '440965', 'antony', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'MSEdge', 'Windows 10 or Windows Server 2016', '0', '登录成功', '2024-04-15 21:22:43');
INSERT INTO `sys_logininfor` VALUES (1779862964204560385, '440965', 'antony', 'pc', 'pc', '0:0:0:0:0:0:0:1', '内网IP', 'MSEdge', 'Windows 10 or Windows Server 2016', '0', '退出成功', '2024-04-15 21:22:54');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '显示状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 4, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-18 15:02:52', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 5, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-18 15:02:59', '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, 'PLUS官网', 0, 6, 'https://gitee.com/dromara/RuoYi-Cloud-Plus', NULL, '', 0, 0, 'M', '0', '1', '', 'guide', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-18 15:03:07', 'RuoYi-Cloud-Plus官网地址');
INSERT INTO `sys_menu` VALUES (6, '租户管理', 0, 2, 'tenant', NULL, '', 1, 0, 'M', '0', '0', '', 'chart', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '租户管理目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-12 16:18:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 9, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:07', '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 10, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:15', '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 11, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:20', '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 12, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:25', '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, 'PowerJob控制台', 2, 2, 'http://localhost:7700', '', '', 0, 0, 'C', '0', '1', 'monitor:job:list', 'job', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-11 15:30:43', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, 'Sentinel控制台', 2, 3, 'http://localhost:8718', '', '', 0, 0, 'C', '0', '1', 'monitor:sentinel:list', 'sentinel', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-11 15:30:36', '流量控制菜单');
INSERT INTO `sys_menu` VALUES (112, 'Nacos控制台', 2, 4, 'http://localhost:8848/nacos', '', '', 0, 0, 'C', '0', '1', 'monitor:nacos:list', 'nacos', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-11 15:30:30', '服务治理菜单');
INSERT INTO `sys_menu` VALUES (113, 'Admin控制台', 2, 5, 'http://localhost:9100/login', '', '', 0, 0, 'C', '0', '1', 'monitor:server:list', 'server', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-11 15:30:24', '服务监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '1', 'tool:build:list', 'build', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-11 15:30:10', '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (118, '文件管理', 1, 13, 'oss', 'system/oss/index', '', 1, 0, 'C', '0', '0', 'system:oss:list', 'upload', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:29', '文件管理菜单');
INSERT INTO `sys_menu` VALUES (121, '租户管理', 6, 1, 'tenant', 'system/tenant/index', '', 1, 0, 'C', '0', '0', 'system:tenant:list', 'list', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '租户管理菜单');
INSERT INTO `sys_menu` VALUES (122, '租户套餐管理', 6, 2, 'tenantPackage', 'system/tenantPackage/index', '', 1, 0, 'C', '0', '0', 'system:tenantPackage:list', 'form', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '租户套餐管理菜单');
INSERT INTO `sys_menu` VALUES (123, '客户端管理', 1, 14, 'client', 'system/client/index', '', 1, 0, 'C', '0', '1', 'system:client:list', 'international', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-15 22:31:35', '客户端管理菜单');
INSERT INTO `sys_menu` VALUES (124, '缓存监控', 2, 1, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '缓存监控');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '账户解锁', 501, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1061, '客户端管理查询', 123, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:client:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1062, '客户端管理新增', 123, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:client:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1063, '客户端管理修改', 123, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:client:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1064, '客户端管理删除', 123, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:client:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1065, '客户端管理导出', 123, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:client:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1600, '文件查询', 118, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1601, '文件上传', 118, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:upload', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1602, '文件下载', 118, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:download', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1603, '文件删除', 118, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1606, '租户查询', 121, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenant:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1607, '租户新增', 121, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenant:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1608, '租户修改', 121, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenant:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1609, '租户删除', 121, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenant:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1610, '租户导出', 121, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenant:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1611, '租户套餐查询', 122, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenantPackage:query', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1612, '租户套餐新增', 122, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenantPackage:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1613, '租户套餐修改', 122, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenantPackage:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1614, '租户套餐删除', 122, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenantPackage:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1615, '租户套餐导出', 122, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:tenantPackage:export', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1620, '配置列表', 118, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:ossConfig:list', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1621, '配置添加', 118, 6, '#', '', '', 1, 0, 'F', '0', '0', 'system:ossConfig:add', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1622, '配置编辑', 118, 6, '#', '', '', 1, 0, 'F', '0', '0', 'system:ossConfig:edit', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1623, '配置删除', 118, 6, '#', '', '', 1, 0, 'F', '0', '0', 'system:ossConfig:remove', '#', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779866489017868290, '成果类型管理', 1, 6, 'achievement', 'base/achievement/index', NULL, 1, 0, 'C', '0', '0', 'base:achievement:list', 'example', 100, 1, '2024-04-15 21:38:24', 1, '2024-04-15 22:19:23', '成果类型管理菜单');
INSERT INTO `sys_menu` VALUES (1779866489017868291, '成果类型查询', 1779866489017868290, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:achievement:query', '#', 100, 1, '2024-04-15 21:38:24', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779866489017868292, '成果类型新增', 1779866489017868290, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:achievement:add', '#', 100, 1, '2024-04-15 21:38:24', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779866489017868293, '成果类型修改', 1779866489017868290, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:achievement:edit', '#', 100, 1, '2024-04-15 21:38:24', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779866489017868294, '成果类型删除', 1779866489017868290, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:achievement:remove', '#', 100, 1, '2024-04-15 21:38:24', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779866489017868295, '成果类型导出', 1779866489017868290, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:achievement:export', '#', 100, 1, '2024-04-15 21:38:24', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779872681727369217, '竞赛类型管理', 1, 7, 'competition', 'base/competition/index', NULL, 1, 0, 'C', '0', '0', 'base:competition:list', 'chart', 100, 1, '2024-04-15 22:02:52', 1, '2024-04-15 22:24:59', '竞赛类型管理菜单');
INSERT INTO `sys_menu` VALUES (1779872681727369218, '竞赛类型查询', 1779872681727369217, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:competition:query', '#', 100, 1, '2024-04-15 22:02:52', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779872681727369219, '竞赛类型新增', 1779872681727369217, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:competition:add', '#', 100, 1, '2024-04-15 22:02:52', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779872681727369220, '竞赛类型修改', 1779872681727369217, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:competition:edit', '#', 100, 1, '2024-04-15 22:02:52', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779872681727369221, '竞赛类型删除', 1779872681727369217, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:competition:remove', '#', 100, 1, '2024-04-15 22:02:52', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779872681727369222, '竞赛类型导出', 1779872681727369217, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:competition:export', '#', 100, 1, '2024-04-15 22:02:52', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779874085883879426, '荣誉类型管理', 1, 8, 'honor', 'base/honor/index', NULL, 1, 0, 'C', '0', '0', 'base:honor:list', 'icon', 100, 1, '2024-04-15 22:08:09', 1, '2024-04-15 22:31:00', '荣誉类型管理菜单');
INSERT INTO `sys_menu` VALUES (1779874085883879427, '荣誉类型查询', 1779874085883879426, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:honor:query', '#', 100, 1, '2024-04-15 22:08:09', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779874085883879428, '荣誉类型新增', 1779874085883879426, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:honor:add', '#', 100, 1, '2024-04-15 22:08:09', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779874085883879429, '荣誉类型修改', 1779874085883879426, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:honor:edit', '#', 100, 1, '2024-04-15 22:08:09', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779874085883879430, '荣誉类型删除', 1779874085883879426, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:honor:remove', '#', 100, 1, '2024-04-15 22:08:09', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1779874085883879431, '荣誉类型导出', 1779874085883879426, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'base:honor:export', '#', 100, 1, '2024-04-15 22:08:09', NULL, NULL, '');
INSERT INTO `sys_menu` VALUES (1780855110512525313, '经历管理', 0, 3, 'experience', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'druid', 100, 1, '2024-04-18 15:05:20', 1, '2024-04-18 15:05:20', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` bigint NOT NULL COMMENT '公告ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint NOT NULL COMMENT '日志主键',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `cost_time` bigint NULL DEFAULT 0 COMMENT '消耗时间',
  PRIMARY KEY (`oper_id`) USING BTREE,
  INDEX `idx_sys_oper_log_bt`(`business_type` ASC) USING BTREE,
  INDEX `idx_sys_oper_log_s`(`status` ASC) USING BTREE,
  INDEX `idx_sys_oper_log_ot`(`oper_time` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1778328311224156161, '440965', '用户管理', 2, 'org.dromara.system.controller.system.SysUserController.edit()', 'PUT', 1, 'admin', 'AntonyCoding科技有限公司', '/user', '0:0:0:0:0:0:0:1', '', '{\"createDept\":null,\"createBy\":null,\"createTime\":\"2024-04-11 15:40:59\",\"updateBy\":null,\"updateTime\":null,\"userId\":\"1778327369355444226\",\"deptId\":\"1778327369087008770\",\"userName\":\"admin\",\"nickName\":\"admin\",\"userType\":\"sys_user\",\"email\":\"\",\"phonenumber\":\"\",\"sex\":\"0\",\"status\":\"0\",\"remark\":null,\"roleIds\":[\"1778327369024094211\"],\"postIds\":[],\"roleId\":\"1778327369024094211\",\"superAdmin\":false}', '{\"code\":200,\"msg\":\"操作成功\",\"data\":null}', 0, '', '2024-04-11 15:44:44', 57);
INSERT INTO `sys_oper_log` VALUES (1781339807877296130, '000000', '操作日志', 3, 'org.dromara.system.controller.monitor.SysOperlogController.remove()', 'DELETE', 1, 'admin', '哈尔滨商业大学', '/operlog/1781339787098714114', '0:0:0:0:0:0:0:1', '', '{}', '{\"code\":200,\"msg\":\"操作成功\",\"data\":null}', 0, '', '2024-04-19 23:11:21', 32);
INSERT INTO `sys_oper_log` VALUES (1781339846032879617, '000000', '登录日志', 9, 'org.dromara.system.controller.monitor.SysLogininforController.clean()', 'DELETE', 1, 'admin', '哈尔滨商业大学', '/logininfor/clean', '0:0:0:0:0:0:0:1', '', '{}', '{\"code\":200,\"msg\":\"操作成功\",\"data\":null}', 0, '', '2024-04-19 23:11:30', 20);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `oss_id` bigint NOT NULL COMMENT '对象存储主键',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件名',
  `original_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '原名',
  `file_suffix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件后缀名',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'URL地址',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '上传人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人',
  `service` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'minio' COMMENT '服务商',
  PRIMARY KEY (`oss_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'OSS对象存储表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------
INSERT INTO `sys_oss` VALUES (1778328035817758721, '000000', '2024/04/11/1ff13e627a8c47f8b13fed7b2eff622e.jpg', '蓝色头像.jpg', '.jpg', 'http://127.0.0.1:9000/student-achievement-saas2/2024/04/11/1ff13e627a8c47f8b13fed7b2eff622e.jpg', 100, '2024-04-11 15:43:38', 1, '2024-04-11 15:43:38', 1, 'minio');

-- ----------------------------
-- Table structure for sys_oss_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss_config`;
CREATE TABLE `sys_oss_config`  (
  `oss_config_id` bigint NOT NULL COMMENT '主建',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `config_key` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '配置key',
  `access_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'accessKey',
  `secret_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '秘钥',
  `bucket_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '桶名称',
  `prefix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '前缀',
  `endpoint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '访问站点',
  `domain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '自定义域名',
  `is_https` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否https（Y=是,N=否）',
  `region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '域',
  `access_policy` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '桶权限类型(0=private 1=public 2=custom)',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否默认（0=是,1=否）',
  `ext1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '扩展字段',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`oss_config_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '对象存储配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss_config
-- ----------------------------
INSERT INTO `sys_oss_config` VALUES (1, '000000', 'minio', 'minioadmin', 'minioadmin', 'student-achievement-saas2', '', '127.0.0.1:9000', '', 'N', '', '1', '0', '', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:43:18', '');
INSERT INTO `sys_oss_config` VALUES (2, '000000', 'qiniu', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi', '', 's3-cn-north-1.qiniucs.com', '', 'N', '', '1', '1', '', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', NULL);
INSERT INTO `sys_oss_config` VALUES (3, '000000', 'aliyun', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi', '', 'oss-cn-beijing.aliyuncs.com', '', 'N', '', '1', '1', '', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', NULL);
INSERT INTO `sys_oss_config` VALUES (4, '000000', 'qcloud', 'XXXXXXXXXXXXXXX', 'XXXXXXXXXXXXXXX', 'ruoyi-1250000000', '', 'cos.ap-beijing.myqcloud.com', '', 'N', 'ap-beijing', '1', '1', '', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', NULL);
INSERT INTO `sys_oss_config` VALUES (5, '000000', 'image', 'ruoyi', 'ruoyi123', 'ruoyi', 'image', '127.0.0.1:9000', '', 'N', '', '1', '1', '', 100, 1, '2024-04-11 15:26:40', 1, '2024-04-11 15:26:40', NULL);

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, '000000', 'admin', '超级管理员', 0, '0', 100, 1, '2024-04-12 17:03:59', 1, '2024-04-12 17:04:03', NULL);
INSERT INTO `sys_post` VALUES (1778709049509531649, '000000', 'undergraduate', '在校学士', 6, '0', 100, 1, '2024-04-12 16:57:39', 1, '2024-04-12 20:07:39', '');
INSERT INTO `sys_post` VALUES (1778709533888729090, '000000', 'advanced', '高级（教授、研究院、副教授、副研究员等）', 1, '0', 100, 1, '2024-04-12 16:59:34', 1, '2024-04-12 16:59:39', '');
INSERT INTO `sys_post` VALUES (1778709670715314178, '000000', 'intermediate', '中级（讲师、助理研究员等）', 2, '0', 100, 1, '2024-04-12 17:00:07', 1, '2024-04-12 17:00:07', '');
INSERT INTO `sys_post` VALUES (1778711006869573634, '000000', 'primary', '初级（助教、研究实习员等）', 3, '0', 100, 1, '2024-04-12 17:05:26', 1, '2024-04-12 17:05:26', '');
INSERT INTO `sys_post` VALUES (1778756967293636610, '000000', 'master', '在校硕士', 5, '0', 100, 1, '2024-04-12 20:08:03', 1, '2024-04-12 20:08:03', '');
INSERT INTO `sys_post` VALUES (1778757025305055233, '000000', 'doctor', '在校博士', 4, '0', 100, 1, '2024-04-12 20:08:17', 1, '2024-04-12 20:08:17', '');
INSERT INTO `sys_post` VALUES (1778757945208197121, '000000', 'graduated_u', '已毕业学士', 9, '0', 100, 1, '2024-04-12 20:11:57', 1, '2024-04-12 20:11:57', '');
INSERT INTO `sys_post` VALUES (1778758102473625601, '000000', 'graduated_m', '已毕业硕士', 8, '0', 100, 1, '2024-04-12 20:12:34', 1, '2024-04-12 20:12:34', '');
INSERT INTO `sys_post` VALUES (1778758184656818177, '000000', 'graduated_d', '已毕业博士', 7, '0', 100, 1, '2024-04-12 20:12:54', 1, '2024-04-12 20:12:54', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '000000', '超级管理员', 'superadmin', 1, '1', 1, 1, '0', '0', 100, 1, '2024-04-11 15:26:39', NULL, NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (1778327369024094211, '440965', '管理员', 'admin', 1, '1', 1, 1, '0', '0', 100, 1, '2024-04-11 15:40:59', 1, '2024-04-11 15:40:59', NULL);
INSERT INTO `sys_role` VALUES (1778692688179744770, '000000', '行政人员', 'administrator', 4, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:52:38', 1, '2024-04-12 16:52:32', '');
INSERT INTO `sys_role` VALUES (1778693078631698434, '000000', '任课教师', 'teacher', 5, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:54:11', 1, '2024-04-12 16:52:52', '');
INSERT INTO `sys_role` VALUES (1778693630723739650, '000000', '辅导员', 'instructor', 6, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:56:23', 1, '2024-04-12 20:01:54', '');
INSERT INTO `sys_role` VALUES (1778693775364313089, '000000', '学校总管', 'boss', 2, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:56:57', 1, '2024-04-12 19:58:05', '');
INSERT INTO `sys_role` VALUES (1778694053375365121, '000000', '研究生', 'postgraduate', 7, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:58:04', 1, '2024-04-12 19:58:48', '');
INSERT INTO `sys_role` VALUES (1778694401477431297, '000000', '本科生', 'undergraduate', 8, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 15:59:27', 1, '2024-04-12 20:06:26', '');
INSERT INTO `sys_role` VALUES (1778708320031985665, '000000', '部门主管', 'director', 3, '1', 1, 1, '0', '0', 100, 1, '2024-04-12 16:54:45', 1, '2024-04-12 16:54:45', '');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (1778327369024094211, 1778327369087008770);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 2);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 100);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 101);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 102);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 103);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 107);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 108);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 109);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 118);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 124);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 500);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 501);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1001);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1002);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1003);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1004);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1005);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1006);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1007);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1008);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1009);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1010);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1011);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1012);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1013);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1014);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1015);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1016);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1017);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1018);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1019);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1020);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1036);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1037);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1038);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1039);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1040);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1041);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1042);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1043);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1044);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1045);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1046);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1047);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1048);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1050);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1600);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1601);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1602);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1603);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1620);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1621);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1622);
INSERT INTO `sys_role_menu` VALUES (1778327369024094211, 1623);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 100);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 101);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 103);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 104);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1001);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1002);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1003);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1004);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1005);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1006);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1007);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1008);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1012);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1017);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1021);
INSERT INTO `sys_role_menu` VALUES (1778692688179744766, 1025);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 1);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 100);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 101);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 103);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 104);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 1001);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 1008);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 1017);
INSERT INTO `sys_role_menu` VALUES (1778692688179744770, 1021);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 1);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 100);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 101);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 103);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 104);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 1001);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 1008);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 1017);
INSERT INTO `sys_role_menu` VALUES (1778693078631698434, 1021);
INSERT INTO `sys_role_menu` VALUES (1778693630723739650, 1);
INSERT INTO `sys_role_menu` VALUES (1778693630723739650, 100);
INSERT INTO `sys_role_menu` VALUES (1778693630723739650, 1001);
INSERT INTO `sys_role_menu` VALUES (1778693630723739650, 1005);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 100);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 101);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 103);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 104);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 107);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1001);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1002);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1003);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1004);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1005);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1006);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1007);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1008);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1009);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1010);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1011);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1012);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1017);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1018);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1019);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1020);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1021);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1022);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1023);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1024);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1025);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1036);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1037);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1038);
INSERT INTO `sys_role_menu` VALUES (1778693775364313089, 1039);
INSERT INTO `sys_role_menu` VALUES (1778694053375365121, 1);
INSERT INTO `sys_role_menu` VALUES (1778694053375365121, 100);
INSERT INTO `sys_role_menu` VALUES (1778694053375365121, 1001);
INSERT INTO `sys_role_menu` VALUES (1778694401477431297, 1);
INSERT INTO `sys_role_menu` VALUES (1778694401477431297, 100);
INSERT INTO `sys_role_menu` VALUES (1778694401477431297, 1001);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 100);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 101);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 103);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 104);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1001);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1002);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1003);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1004);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1005);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1006);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1007);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1008);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1012);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1017);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1020);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1021);
INSERT INTO `sys_role_menu` VALUES (1778708320031985665, 1025);

-- ----------------------------
-- Table structure for sys_social
-- ----------------------------
DROP TABLE IF EXISTS `sys_social`;
CREATE TABLE `sys_social`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户id',
  `auth_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '平台+平台唯一id',
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户来源',
  `open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台编号唯一id',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的授权令牌',
  `expire_in` int NULL DEFAULT NULL COMMENT '用户的授权令牌的有效期，部分平台可能没有',
  `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新令牌，部分平台可能没有',
  `access_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台的授权信息，部分平台可能没有',
  `union_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的 unionid',
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授予的权限，部分平台可能没有',
  `token_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个别平台的授权信息，部分平台可能没有',
  `id_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'id token，部分平台可能没有',
  `mac_algorithm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小米平台用户的附带属性，部分平台可能没有',
  `mac_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小米平台用户的附带属性，部分平台可能没有',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的授权code，部分平台可能没有',
  `oauth_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Twitter平台用户的附带属性，部分平台可能没有',
  `oauth_token_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Twitter平台用户的附带属性，部分平台可能没有',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '社会化关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_social
-- ----------------------------

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant`  (
  `id` bigint NOT NULL COMMENT 'id',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
  `contact_user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `company_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `license_number` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '统一社会信用代码',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业简介',
  `domain` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '域名',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `package_id` bigint NULL DEFAULT NULL COMMENT '租户套餐编号',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  `account_count` int NULL DEFAULT -1 COMMENT '用户数量（-1不限制）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '租户状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
INSERT INTO `sys_tenant` VALUES (1, '000000', '哈尔滨商业大学王老师', '17388888888', '哈尔滨商业大学', NULL, NULL, '基于云原生的学生在校经历管理SaaS系统', NULL, NULL, NULL, NULL, -1, '0', '0', 100, 1, '2024-04-11 15:26:39', NULL, NULL);
INSERT INTO `sys_tenant` VALUES (1778327369024094210, '440965', '哈尔滨XXX大学张老师', '17388888888', '哈尔滨XXX大学', '', '', '', '', '', 1778327213000179714, NULL, 10, '0', '0', 100, 1, '2024-04-11 15:40:59', 1, '2024-04-12 16:14:47');

-- ----------------------------
-- Table structure for sys_tenant_package
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant_package`;
CREATE TABLE `sys_tenant_package`  (
  `package_id` bigint NOT NULL COMMENT '租户套餐id',
  `package_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '套餐名称',
  `menu_ids` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联菜单id',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`package_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户套餐表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tenant_package
-- ----------------------------
INSERT INTO `sys_tenant_package` VALUES (1778327213000179714, '普通套餐', '1, 2, 100, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 101, 1008, 1009, 1010, 1011, 1012, 102, 1013, 1014, 1015, 1016, 103, 1017, 1018, 1019, 1020, 107, 1036, 1037, 1038, 1039, 108, 500, 1040, 1041, 1042, 501, 1043, 1044, 1045, 1050, 118, 1600, 1601, 1602, 1603, 1620, 1621, 1622, 1623, 109, 1046, 1047, 1048, 124', '', 1, '0', '0', 100, 1, '2024-04-11 15:40:22', 1, '2024-04-12 17:12:02');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '000000' COMMENT '租户编号',
  `dept_id` bigint NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'sys_user' COMMENT '用户类型（sys_user系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` bigint NULL DEFAULT NULL COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_dept` bigint NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '000000', 100, 'admin', '超级管理员', 'sys_user', '1911111111@qq.com', '15100000000', '0', 1778328035817758721, '$2a$10$rUU2oeiYVhFJ.Nkbfeywsel61TT5gxL7MKYUcd6O38ADtbeNmlJGa', '0', '0', '0:0:0:0:0:0:0:1', '2024-04-19 23:03:59', 100, 1, '2024-04-11 15:26:39', 1, '2024-04-19 23:03:59', '管理员');
INSERT INTO `sys_user` VALUES (1778327369355444226, '440965', 1778327369087008770, 'antony', '超级管理员', 'sys_user', '1911111111@qq.com', '17388888888', '0', NULL, '$2a$10$m/yshNiHPDU/gJdEgTnJwO1ZhxSGlx6Db/bBjJHzfiMfN4zrSSOym', '0', '0', '0:0:0:0:0:0:0:1', '2024-04-15 21:22:43', 100, 1, '2024-04-11 15:40:59', 1, '2024-04-18 22:34:53', NULL);
INSERT INTO `sys_user` VALUES (1778704505606098945, '000000', 1779738476230017025, 'gx9066', '高祥', 'sys_user', '', '13933333333', '0', NULL, '$2a$10$1N3v3dFBvWVzhE80xIvxe.9zYBGsyPgXaosc8IeWIkU01YpBRizE2', '0', '0', '', NULL, 100, 1, '2024-04-12 16:39:36', 1, '2024-04-19 23:10:24', '');
INSERT INTO `sys_user` VALUES (1778704704135090177, '000000', 1779760160337100802, 'wcc1985', '伍程成', 'sys_user', '1911261716@qq.com', '17388888888', '0', NULL, '$2a$10$n4S7BTKIedcMNJhShfzwoO0lbETARKZlR8zejSoZq7YI0OK8YH.2u', '0', '0', '0:0:0:0:0:0:0:1', '2024-04-18 15:12:19', 100, 1, '2024-04-12 16:40:23', 1, '2024-04-19 23:10:32', '');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (1778704505606098945, 1778709670715314178);
INSERT INTO `sys_user_post` VALUES (1778704704135090177, 1778709049509531649);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1778327369355444226, 1778327369024094211);
INSERT INTO `sys_user_role` VALUES (1778704505606098945, 1778693078631698434);
INSERT INTO `sys_user_role` VALUES (1778704704135090177, 1778694401477431297);

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `branch_id` bigint NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE INDEX `ux_undo_log`(`xid` ASC, `branch_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'AT transaction mode undo table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
