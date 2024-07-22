/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2022-10-21 09:44:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cname` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '课程名字',
  PRIMARY KEY (`cname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('数学');
INSERT INTO `course` VALUES ('英语');
INSERT INTO `course` VALUES ('语文');

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `rid` bigint NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `uid` bigint DEFAULT NULL,
  `rtime` varchar(50) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `rcondition` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT '出勤',
  PRIMARY KEY (`rid`),
  KEY `FK_records_course` (`cname`),
  KEY `FK_records_user` (`uid`),
  CONSTRAINT `FK_records_course` FOREIGN KEY (`cname`) REFERENCES `course` (`cname`),
  CONSTRAINT `FK_records_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `CC1` CHECK (((`rcondition` = _utf8mb4'出勤') or (`rcondition` = _utf8mb4'请假') or (`rcondition` = _utf8mb4'旷课') or (`rcondition` = _utf8mb4'迟到') or (`rcondition` = _utf8mb4'早退')))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of records
-- ----------------------------
INSERT INTO `records` VALUES ('1', '语文', '20001', '2022年10月10日', '出勤');
INSERT INTO `records` VALUES ('2', '语文', '20002', '2022年10月10日', '请假');
INSERT INTO `records` VALUES ('3', '语文', '20003', '2022年10月10日', '旷课');
INSERT INTO `records` VALUES ('4', '数学', '20001', '2022年10月10日', '早退');
INSERT INTO `records` VALUES ('5', '数学', '20002', '2022年10月10日', '迟到');
INSERT INTO `records` VALUES ('6', '数学', '20003', '2022年10月10日', '出勤');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` bigint NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `upass` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `uclass` varchar(50) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `utype` int DEFAULT '2',
  PRIMARY KEY (`uid`),
  CONSTRAINT `CC12` CHECK (((`utype` = 0) or (`utype` = 1) or (`utype` = 2)))
) ENGINE=InnoDB AUTO_INCREMENT=20006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', 'admin', 'admin', null, '0');
INSERT INTO `user` VALUES ('10001', '王语文', 'yvwen', null, '1');
INSERT INTO `user` VALUES ('10002', '李数学', 'shuxue', null, '1');
INSERT INTO `user` VALUES ('10003', '陈英语', 'yingyv', null, '1');
INSERT INTO `user` VALUES ('10004', '李政治', 'zhengzhi', null, '1');
INSERT INTO `user` VALUES ('20001', '凌小摆', 'ling', '201', '2');
INSERT INTO `user` VALUES ('20002', '丘小摆', 'qiu', '202', '2');
INSERT INTO `user` VALUES ('20003', '周小摆', 'zhou', '201', '2');
