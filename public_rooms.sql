/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : public_rooms

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-07-13 21:18:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ADMIN_ID` varchar(20) NOT NULL,
  `ADMIN_PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('root', 'root');

-- ----------------------------
-- Table structure for `rent`
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent` (
  `ROOM_ID` varchar(20) NOT NULL,
  `ROOM_NAME` varchar(20) NOT NULL,
  `TYPE` enum('分配','租赁') NOT NULL,
  `RENTER` varchar(20) NOT NULL,
  `RENTER_NAME` varchar(20) NOT NULL,
  `RENTER_ID` varchar(20) NOT NULL,
  `RENTER_PHONE` varchar(20) NOT NULL,
  `RENT_START_DATE` date NOT NULL,
  `RENT_END_DATE` date NOT NULL,
  `RENT_DAY` varchar(20) DEFAULT NULL,
  `RENT_HIRES` varchar(20) DEFAULT NULL,
  `RENT_HIRE` varchar(20) DEFAULT NULL,
  `RENT_OTHER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ROOM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent
-- ----------------------------
INSERT INTO `rent` VALUES ('r1', 'r1', '分配', 'd1', 'd1', 'd1', 'd1', '2017-05-17', '2017-05-17', null, null, null, 'd1');
INSERT INTO `rent` VALUES ('r2', 'r2', '租赁', 'd2', 'd2', 'd2', 'd2', '2017-05-18', '2017-06-17', '30', '600', '20', 'd2');

-- ----------------------------
-- Table structure for `rent_logs`
-- ----------------------------
DROP TABLE IF EXISTS `rent_logs`;
CREATE TABLE `rent_logs` (
  `NO` int(11) NOT NULL AUTO_INCREMENT,
  `ROOM_ID` varchar(20) NOT NULL,
  `ROOM_NAME` varchar(20) NOT NULL,
  `TYPE` enum('分配','租赁') NOT NULL,
  `RENTER` varchar(20) NOT NULL,
  `RENTER_NAME` varchar(20) NOT NULL,
  `RENTER_ID` varchar(20) NOT NULL,
  `RENTER_PHONE` varchar(20) NOT NULL,
  `RENT_START_DATE` date NOT NULL,
  `RENT_END_DATE` date NOT NULL,
  `RENT_DAY` varchar(20) DEFAULT NULL,
  `RENT_HIRES` varchar(20) DEFAULT NULL,
  `RENT_HIRE` varchar(20) DEFAULT NULL,
  `RENT_OTHER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent_logs
-- ----------------------------
INSERT INTO `rent_logs` VALUES ('6', 'r5', 'r5', '租赁', 'd5', 'd5', 'd5', 'd5', '2017-04-16', '2017-05-16', '30', '1500', '50', 'd5');

-- ----------------------------
-- Table structure for `repair`
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `NO` int(11) NOT NULL AUTO_INCREMENT,
  `ROOM_ID` varchar(20) NOT NULL,
  `ROOM_NAME` varchar(20) NOT NULL,
  `REPAIRER` varchar(20) NOT NULL,
  `REPAIRER_PHONE` varchar(20) NOT NULL,
  `REPAIR_HIRE` varchar(20) NOT NULL,
  `REPAIR_DATE` date NOT NULL,
  `REPAIR_OTHER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('6', 'r3', 'r3', 'd3', 'd3', '30', '2017-05-17', '');
INSERT INTO `repair` VALUES ('7', 'r4', 'r4', 'r4', 'r4', '40', '2017-05-18', '');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `ROOM_ID` varchar(20) NOT NULL,
  `ROOM_NAME` varchar(20) NOT NULL,
  `ROOM_BUILDING` varchar(20) NOT NULL,
  `ROOM_FLOOR` varchar(20) NOT NULL,
  `ROOM_AREA` varchar(20) NOT NULL,
  `ROOM_HIRE` varchar(20) NOT NULL,
  `ROOM_OTHER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ROOM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('r1', 'r1', 'r1', 'r1', 'r1', '10', 'r1');
INSERT INTO `room` VALUES ('r2', 'r2', 'r2', 'r2', 'r2', '20', 'r2');
INSERT INTO `room` VALUES ('r3', 'r3', 'r3', 'r3', 'r3', '30', 'r3');
INSERT INTO `room` VALUES ('r4', 'r4', 'r4', 'r4', 'r4', '40', 'r4');
INSERT INTO `room` VALUES ('r5', 'r5', 'r5', 'r5', 'r5', '50', 'r5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` varchar(20) NOT NULL,
  `USER_NO` varchar(20) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PHONE` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user1', 'user1', 'user1', 'user1', '111');
INSERT INTO `user` VALUES ('user2', 'user2', 'user2', 'user2', '222');
INSERT INTO `user` VALUES ('user3', 'user3', 'user3', 'user3', '333');
INSERT INTO `user` VALUES ('user4', 'user4', 'user4', 'user4', '444');
INSERT INTO `user` VALUES ('user5', 'user5', 'user5', 'user5', '555');
