/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : ssms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-26 17:28:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `perms` varchar(50) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `ordernum` int(2) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createby` varchar(50) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateby` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `parentid` varchar(50) DEFAULT NULL,
  `parentids` varchar(50) DEFAULT NULL,
  `isdelete` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) DEFAULT NULL,
  `rolekey` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createby` varchar(50) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateby` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) DEFAULT NULL,
  `permissionsid` bigint(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createby` varchar(50) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createby` varchar(50) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateby` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', null, '1', 'pengcq', null, null, '2017-11-26 17:18:02', null, '2017-11-26 17:18:02', null, null);

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `roleid` bigint(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createby` varchar(50) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
