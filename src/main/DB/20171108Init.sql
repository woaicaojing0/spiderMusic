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

/*Table structure for table `new_house_info` */

DROP TABLE IF EXISTS `new_house_info`;

CREATE TABLE `new_house_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `houseId` int(11) DEFAULT NULL,
  `houseName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `houseAddress` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `houseBig` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `houseType` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `referencePrice` decimal(10,0) DEFAULT NULL,
  `referencePriceUnit` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `referencePriceType` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `circumPrice` decimal(10,0) DEFAULT NULL,
  `contactNumber` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `imgUrl` text COLLATE utf8_bin,
  `baiduLat` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `baiduLng` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2326 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
