/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.225.5_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 192.168.225.5:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 27/06/2019 18:22:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users`  (
  `id` varchar(36) CHARACTER SET utf16 COLLATE utf16_general_ci NOT NULL,
  `account` varchar(64) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  `password` varchar(48) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  `salt` varchar(16) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf16 COLLATE = utf16_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
