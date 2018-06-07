/*
SQLyog Community v12.2.4 (64 bit)
MySQL - 5.7.19 : Database - spiderhouse
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spiderhouse` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `spiderhouse`;

/*Table structure for table `day_count` */

DROP TABLE IF EXISTS `day_count`;

CREATE TABLE `day_count` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `day` DATETIME DEFAULT NULL COMMENT '日期',
  `NewHouseCount` INT(11) DEFAULT NULL COMMENT '新房数量',
  `SecondHouseCount` INT(11) DEFAULT NULL COMMENT '二手房数量',
  `TenementCount` INT(11) DEFAULT NULL COMMENT '租房数量',
  `type` ENUM('DAY','MONTH','YEAR') COLLATE utf8_bin DEFAULT NULL COMMENT '类型有日 月 年',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `new_house_info` */

DROP TABLE IF EXISTS `new_house_info`;

CREATE TABLE `new_house_info` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `houseId` INT(11) DEFAULT NULL,
  `houseName` VARCHAR(100) COLLATE utf8_bin DEFAULT NULL,
  `houseAddress` VARCHAR(400) COLLATE utf8_bin DEFAULT NULL,
  `houseBig` VARCHAR(200) COLLATE utf8_bin DEFAULT NULL,
  `houseType` VARCHAR(200) COLLATE utf8_bin DEFAULT NULL,
  `referencePrice` DECIMAL(10,0) DEFAULT NULL,
  `referencePriceUnit` VARCHAR(20) COLLATE utf8_bin DEFAULT NULL,
  `referencePriceType` VARCHAR(20) COLLATE utf8_bin DEFAULT NULL,
  `circumPrice` DECIMAL(10,0) DEFAULT NULL,
  `contactNumber` VARCHAR(100) COLLATE utf8_bin DEFAULT NULL,
  `imgUrl` TEXT COLLATE utf8_bin,
  `baiduLng` VARCHAR(40) COLLATE utf8_bin DEFAULT NULL,
  `baiduLat` VARCHAR(40) COLLATE utf8_bin DEFAULT NULL,
  `createTime` DATE DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1743 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
