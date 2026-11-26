/*
 设备管理业务表。
 目标库：ruoyi-vue-pro-jdk8
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE IF NOT EXISTS `equipment_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '设备编码',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态（0开启 1关闭）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_equipment_device_name` (`name`) USING BTREE,
  KEY `idx_equipment_device_status` (`status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '设备表';

INSERT INTO `equipment_device` (`name`, `code`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT '数控车床', 'EQ-001', 0, '一号车间', '1', '2026-01-10 09:00:00', '1', '2026-01-10 09:00:00', b'0', 1
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM `equipment_device` WHERE `code` = 'EQ-001' AND `deleted` = b'0');

INSERT INTO `equipment_device` (`name`, `code`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT '激光切割机', 'EQ-002', 0, '二号车间', '1', '2026-03-15 14:30:00', '1', '2026-03-15 14:30:00', b'0', 1
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM `equipment_device` WHERE `code` = 'EQ-002' AND `deleted` = b'0');

INSERT INTO `equipment_device` (`name`, `code`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT '空压机', 'EQ-003', 1, '停用检修', '1', '2026-06-01 08:20:00', '1', '2026-06-01 08:20:00', b'0', 1
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM `equipment_device` WHERE `code` = 'EQ-003' AND `deleted` = b'0');

SET FOREIGN_KEY_CHECKS = 1;
