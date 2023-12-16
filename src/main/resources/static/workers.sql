/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : vue-element-admin

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 16/12/2023 20:44:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for workers
-- ----------------------------
DROP TABLE IF EXISTS `workers`;
CREATE TABLE `workers`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workers
-- ----------------------------
INSERT INTO `workers` VALUES (1, '张一', '男', '25', '业务部', '本科');
INSERT INTO `workers` VALUES (2, '张二', '女', '26', '人事部', '本科');
INSERT INTO `workers` VALUES (3, '张三', '男', '27', '后勤部', '大专');
INSERT INTO `workers` VALUES (4, '张四', '女', '28', '人事部', '大专');
INSERT INTO `workers` VALUES (5, '张五', '男', '29', '后勤部', '大专');
INSERT INTO `workers` VALUES (6, '张六', '女', '29', '后勤部', '本科');
INSERT INTO `workers` VALUES (7, '张七', '男', '33', '业务部', '研究生');
INSERT INTO `workers` VALUES (8, '张八', '男', '32', '业务部', '本科');
INSERT INTO `workers` VALUES (9, '张九', '女', '33', '业务部', '大专');
INSERT INTO `workers` VALUES (10, '李一', '女', '45', '业务部', '研究生');
INSERT INTO `workers` VALUES (11, '李二', '女', '19', '人事部', '本科');
INSERT INTO `workers` VALUES (12, '李三', '男', '28', '业务部', '研究生');
INSERT INTO `workers` VALUES (13, '李四', '女', '46', '后勤部', '研究生');
INSERT INTO `workers` VALUES (14, '李五', '男', '58', '业务部', '大专');
INSERT INTO `workers` VALUES (15, '李六', '女', '22', '人事部', '研究生');
INSERT INTO `workers` VALUES (16, '李七', '男', '26', '后勤部', '大专');
INSERT INTO `workers` VALUES (17, '李八', '男', '25', '人事部', '研究生');
INSERT INTO `workers` VALUES (18, '李九', '女', '29', '后勤部', '研究生');
INSERT INTO `workers` VALUES (19, '王一', '男', '45', '后勤部', '本科');
INSERT INTO `workers` VALUES (20, '王二', '女', '21', '业务部', '本科');
INSERT INTO `workers` VALUES (21, '王三', '男', '21', '业务部', '大专');
INSERT INTO `workers` VALUES (22, '王四', '男', '23', '业务部', '大专');
INSERT INTO `workers` VALUES (23, '王五', '女', '33', '业务部', '大专');
INSERT INTO `workers` VALUES (24, '王六', '男', '45', '人事部', '本科');
INSERT INTO `workers` VALUES (25, '王七', '男', '35', '业务部', '研究生');
INSERT INTO `workers` VALUES (26, '王八', '男', '41', '后勤部', '本科');
INSERT INTO `workers` VALUES (27, '王九', '女', '25', '业务部', '大专');
INSERT INTO `workers` VALUES (28, '赵一', '男', '26', '人事部', '研究生');
INSERT INTO `workers` VALUES (29, '赵二', '男', '20', '后勤部', '本科');
INSERT INTO `workers` VALUES (30, '赵三', '女', '21', '人事部', '研究生');
INSERT INTO `workers` VALUES (31, '赵四', '男', '19', '后勤部', '研究生');
INSERT INTO `workers` VALUES (32, '赵五', '女', '35', '后勤部', '大专');
INSERT INTO `workers` VALUES (33, '赵六', '男', '24', '业务部', '研究生');
INSERT INTO `workers` VALUES (34, '赵七', '男', '29', '业务部', '大专');
INSERT INTO `workers` VALUES (35, '赵八', '女', '33', '业务部', '研究生');
INSERT INTO `workers` VALUES (36, '赵九', '男', '45', '业务部', '本科');
INSERT INTO `workers` VALUES (37, '测试', '测试', '测试修改', '测试', '测试修改');

SET FOREIGN_KEY_CHECKS = 1;
