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

/*Table structure for table `album_info` */

DROP TABLE IF EXISTS `album_info`;

CREATE TABLE `album_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `album_id` int(11) DEFAULT NULL COMMENT '专辑id',
  `album_name` varchar(120) COLLATE utf8_bin DEFAULT NULL COMMENT '专辑名称',
  `album_time` datetime DEFAULT NULL COMMENT '专辑时间',
  `album_company` varchar(240) COLLATE utf8_bin DEFAULT NULL COMMENT '专辑所属公司',
  `album_singer_name` varbinary(60) DEFAULT NULL COMMENT '歌手名称',
  `album_singer_id` int(11) DEFAULT NULL COMMENT '歌手id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=299 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `day_count` */

DROP TABLE IF EXISTS `day_count`;

CREATE TABLE `day_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` datetime DEFAULT NULL COMMENT '日期',
  `NewHouseCount` int(11) DEFAULT NULL COMMENT '新房数量',
  `SecondHouseCount` int(11) DEFAULT NULL COMMENT '二手房数量',
  `TenementCount` int(11) DEFAULT NULL COMMENT '租房数量',
  `type` enum('DAY','MONTH','YEAR') COLLATE utf8_bin DEFAULT NULL COMMENT '类型有日 月 年',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `musci_comment` */

DROP TABLE IF EXISTS `musci_comment`;

CREATE TABLE `musci_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `songId` int(11) DEFAULT NULL COMMENT '歌曲id',
  `nickname` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '评论人姓名',
  `likedCount` int(20) DEFAULT NULL COMMENT '赞数',
  `content` text COLLATE utf8_bin COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `music_info` */

DROP TABLE IF EXISTS `music_info`;

CREATE TABLE `music_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `songId` int(11) DEFAULT NULL COMMENT '歌曲id',
  `title` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '歌曲名称',
  `author_id` int(11) DEFAULT NULL COMMENT '演唱者id',
  `author` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '演唱者',
  `album` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '专辑',
  `URL` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '播放地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=624 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  `baiduLng` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `baiduLat` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `createTime` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1743 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `singer_info` */

DROP TABLE IF EXISTS `singer_info`;

CREATE TABLE `singer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `singer_id` int(11) DEFAULT NULL COMMENT '歌手id',
  `singer_name` varchar(120) COLLATE utf8_bin NOT NULL COMMENT '歌手姓名',
  `singer_description` text COLLATE utf8_bin COMMENT '歌手介绍',
  `singer_href` text COLLATE utf8_bin COMMENT '歌手主页',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50015 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
