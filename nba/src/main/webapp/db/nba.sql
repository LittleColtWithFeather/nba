/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.15 : Database - nba
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nba` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nba`;

/*Table structure for table `t_players` */

DROP TABLE IF EXISTS `t_players`;

CREATE TABLE `t_players` (
  `playerId` int(11) NOT NULL AUTO_INCREMENT,
  `playerName` varchar(30) NOT NULL,
  `playerAge` int(2) DEFAULT NULL,
  `playerHeight` double(3,2) DEFAULT NULL,
  `playerTeam` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`playerId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `t_players` */

insert  into `t_players`(`playerId`,`playerName`,`playerAge`,`playerHeight`,`playerTeam`) values (15,'Kobe Bryant',42,1.98,'Los Angeles Lakers'),(16,'Stephen Curry',32,1.91,'Golden State Warriors'),(18,'LeBron James',36,2.03,'Los Angeles Lakers'),(19,'Yao Ming',40,2.26,'Houston Rockets'),(20,'Tracy McGrady',41,2.03,'Orlando Magic'),(21,'Shaquille ONeal',48,2.06,'Orlando Magic');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
