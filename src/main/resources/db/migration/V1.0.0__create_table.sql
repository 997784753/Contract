SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_term
-- ----------------------------
DROP TABLE IF EXISTS `base_term`;
CREATE TABLE `base_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `area_size` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租赁数',
  `deposit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '押金',
  `deposit_unit_enum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '押金单位',
  `lease_degin_date` datetime(0) NULL DEFAULT NULL COMMENT '合同计租开始时间',
  `lease_end_date` datetime(0) NULL DEFAULT NULL COMMENT '合同计租结束时间',
  `monetary_unit` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '币种',
  `sign_date` datetime(0) NULL DEFAULT NULL COMMENT '签订时间',
  `space_unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租赁数单位',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKe4btae8nyplkreu121wjbrry1`(`contract_id`) USING BTREE,
  CONSTRAINT `FKe4btae8nyplkreu121wjbrry1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `legal_person_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '法人',
  `contract_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同编号',
  `created_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '创建人Id',
  `created_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `enddate` date NULL DEFAULT NULL COMMENT '合同失效时间',
  `follow_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '跟进人',
  `follow_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '跟进人名',
  `industry_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '行业类型',
  `last_modified_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '最后修改人Id',
  `last_modified_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `last_modified_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `org_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '组织id',
  `property_contract_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '物业联系人',
  `signer_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '签订人',
  `site_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '站点Id',
  `start_date` date NULL DEFAULT NULL COMMENT '合同计租时间',
  `tenant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租客联系人id',
  `tenant_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '最后修改人Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deposit_increasing_rate_term
-- ----------------------------
DROP TABLE IF EXISTS `deposit_increasing_rate_term`;
CREATE TABLE `deposit_increasing_rate_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `apply_date` date NULL DEFAULT NULL COMMENT '递增日期',
  `count` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '递增数量',
  `increase_rata_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '递增类型PERCENT(%),MONEY(元)',
  `time_interval` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '间隔YEAR(年),MOUTH(月)',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKripi9vicvwjqsxqpux9xkfvva`(`contract_id`) USING BTREE,
  CONSTRAINT `FKripi9vicvwjqsxqpux9xkfvva` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lease_term
-- ----------------------------
DROP TABLE IF EXISTS `lease_term`;
CREATE TABLE `lease_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `calculate_enum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '计算枚举',
  `day_number_for_year` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '一年算多少天',
  `interval_month` int(11) NULL DEFAULT NULL COMMENT '几月一付',
  `lease_divide_role_enum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租期划分规则 枚举   STARTINGDATE(按起始日划分) THENEXTMONTH(次月按自然月划分(仅一月一付有效)) FirstBill(按自然月划分(首月非整自然月划入第一期)) CalculateAMonth(按自然月划分(首月非整自然月算一个月))',
  `monetary_unit` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '货币单位',
  `month_price_convert_role_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '天单价换算规则 YEAR(按年换算：天单价=月单价*12/年天数) MONTH(按自然月换算：天单价=月单价/自然月的天数)',
  `pay_in_advance_day` int(11) NULL DEFAULT NULL COMMENT '付款提前时间',
  `payment_date_enum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '提前时间类型 NATURALDAY(自然日),WORKDAY(工作日),APPOINTEDDAY(指定日期)',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '合同单价',
  `price_unit_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同单价枚举  D(元/㎡·天), M(元/㎡·月), YM(元/月), YD(元/天), GD(元/工位·天), GM(元/工位·月);',
  `term_begin_date` date NULL DEFAULT NULL COMMENT '开始时间',
  `term_end_date` date NULL DEFAULT NULL COMMENT '结束时间',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK87yx3871pnwe6flil5wbh6y06`(`contract_id`) USING BTREE,
  CONSTRAINT `FK87yx3871pnwe6flil5wbh6y06` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for over_due_fine_term
-- ----------------------------
DROP TABLE IF EXISTS `over_due_fine_term`;
CREATE TABLE `over_due_fine_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `rate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '比例%/天',
  `upper_limit_rate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '滞纳金上限%',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK1ay5s2va0mw0ecsbnrdfrkdho`(`contract_id`) USING BTREE,
  CONSTRAINT `FK1ay5s2va0mw0ecsbnrdfrkdho` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `end_date` date NULL DEFAULT NULL COMMENT '结束时间',
  `final_price` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '最终单价',
  `monetary_unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '币种（人民币CNY)',
  `org_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '组织id',
  `pay_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '付款类型 枚举：DEPOSIT(押金), RENT(租金), ENERGYCONSUM(能耗费), PROPERTY(物业费), RENT_DEPOSIT(租金保证金), PROPERTY_DEPOSIT(物业保证金), OTHER(其他);',
  `price_unit_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '单位 D(元/㎡·天), M(元/㎡·月), YM(元/月), YD(元/天), GD(元/工位·天), GM(元/工位·月);',
  `site_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '站点Id',
  `start_date` date NULL DEFAULT NULL COMMENT '开始时间',
  `theory_pay_date` date NULL DEFAULT NULL COMMENT '付款日期',
  `theory_pay_money` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '最终金额',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKehow2co5dfptfp24hmv4uaxj2`(`contract_id`) USING BTREE,
  CONSTRAINT `FKehow2co5dfptfp24hmv4uaxj2` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for promotion_term
-- ----------------------------
DROP TABLE IF EXISTS `promotion_term`;
CREATE TABLE `promotion_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `begin_date` date NULL DEFAULT NULL COMMENT '开始时间',
  `discount_enum` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '折扣类型（枚举）RENTFREE(免租期) TRIM(装修期)   DISCOUNT(单价折扣) REMISSION(减免金额) UNITPRICE(单价减免)',
  `discount_number` int(11) NULL DEFAULT NULL COMMENT '折扣数',
  `end_date` date NULL DEFAULT NULL COMMENT '结束时间',
  `free_money` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '减免金额',
  `remark` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '备注',
  `lease_term_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租期条款ID',
  `water_electricity_term_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '水电条款ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKffmybf7i6t5btgol0qbljo8sr`(`lease_term_id`) USING BTREE,
  INDEX `FKc6kspspohc8okjtea7lbjcu27`(`water_electricity_term_id`) USING BTREE,
  CONSTRAINT `FKc6kspspohc8okjtea7lbjcu27` FOREIGN KEY (`water_electricity_term_id`) REFERENCES `water_electricity_term` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKffmybf7i6t5btgol0qbljo8sr` FOREIGN KEY (`lease_term_id`) REFERENCES `lease_term` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for termination_term
-- ----------------------------
DROP TABLE IF EXISTS `termination_term`;
CREATE TABLE `termination_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `audit_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '审核状态',
  `deposit_paid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '保证金总额',
  `lease_paid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租金总额',
  `leasereceivable` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '应收款总额',
  `liquidated_damages_receivable` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '违约金应收',
  `sign_date` date NULL DEFAULT NULL COMMENT '签署日期',
  `tenant` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租客名称',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '租客ID',
  `total_amount` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '总计',
  `total_paid` decimal(10, 0) NULL DEFAULT NULL COMMENT '总面积',
  `total_receivable` decimal(10, 0) NULL DEFAULT NULL COMMENT '总应收',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK76tbfheny7y4unkxym4pfnu7g`(`contract_id`) USING BTREE,
  CONSTRAINT `FK76tbfheny7y4unkxym4pfnu7g` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for water_electricity_term
-- ----------------------------
DROP TABLE IF EXISTS `water_electricity_term`;
CREATE TABLE `water_electricity_term`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `is_del` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `electric_unit_price` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '电费单价',
  `water_unit_price` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '水费单价',
  `contract_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK89bx8iwe0jbk2jv02h05vm8ie`(`contract_id`) USING BTREE,
  CONSTRAINT `FK89bx8iwe0jbk2jv02h05vm8ie` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
