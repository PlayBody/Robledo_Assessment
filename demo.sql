/*
 Navicat Premium Data Transfer

 Source Server         : con
 Source Server Type    : MySQL
 Source Server Version : 100425
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 100425
 File Encoding         : 65001

 Date: 11/10/2023 01:53:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'John Doe');
INSERT INTO `customer` VALUES (2, 'Jane Smith');
INSERT INTO `customer` VALUES (3, 'Bob Williams');

-- ----------------------------
-- Table structure for customer_transactions
-- ----------------------------
DROP TABLE IF EXISTS `customer_transactions`;
CREATE TABLE `customer_transactions`  (
  `customer_id` bigint NOT NULL,
  `transactions_id` bigint NOT NULL,
  UNIQUE INDEX `UK_1vskh29saveqya2u0tbymh26x`(`transactions_id` ASC) USING BTREE,
  INDEX `FKmaae9pb34ym9gsllyv3h029ye`(`customer_id` ASC) USING BTREE,
  CONSTRAINT `FKmaae9pb34ym9gsllyv3h029ye` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKok6f8kifjcb0l6bg5m93ythi` FOREIGN KEY (`transactions_id`) REFERENCES `transaction` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_transactions
-- ----------------------------

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `id` bigint NOT NULL,
  `amount` int NOT NULL,
  `date` datetime(6) NULL DEFAULT NULL,
  `customer_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnbpjofb5abhjg5hiovi0t3k57`(`customer_id` ASC) USING BTREE,
  CONSTRAINT `FKnbpjofb5abhjg5hiovi0t3k57` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES (1, 120, '2023-08-15 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (2, 150, '2023-08-25 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (3, 180, '2023-09-05 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (4, 75, '2023-09-15 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (5, 110, '2023-10-01 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (6, 190, '2023-10-12 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (7, 165, '2023-10-20 00:00:00.000000', 1);
INSERT INTO `transaction` VALUES (9, 155, '2023-08-10 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (10, 100, '2023-08-22 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (11, 125, '2023-09-03 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (12, 170, '2023-09-17 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (13, 150, '2023-10-05 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (14, 135, '2023-10-15 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (15, 175, '2023-10-25 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (16, 185, '2023-10-30 00:00:00.000000', 2);
INSERT INTO `transaction` VALUES (17, 60, '2023-08-05 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (18, 95, '2023-08-12 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (19, 105, '2023-08-25 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (20, 70, '2023-09-08 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (21, 130, '2023-09-20 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (22, 145, '2023-10-02 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (23, 165, '2023-10-15 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (24, 180, '2023-10-22 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (25, 195, '2023-10-28 00:00:00.000000', 3);
INSERT INTO `transaction` VALUES (26, 175, '2023-10-31 00:00:00.000000', 3);

SET FOREIGN_KEY_CHECKS = 1;
