/*
SQLyog Community Edition- MySQL GUI v8.17 
MySQL - 5.6.22-log : Database - gestion_mvc_bd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestion_mvc_bd` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gestion_mvc_bd`;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usuId` int(11) NOT NULL,
  `usuNom` varchar(45) NOT NULL,
  `usuIdent` varchar(20) NOT NULL,
  `usuClavePass` varchar(45) NOT NULL,
  `usuEstado` int(11) NOT NULL,
  PRIMARY KEY (`usuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`usuId`,`usuNom`,`usuIdent`,`usuClavePass`,`usuEstado`) values (0,'JUANCARLOS','88031585','93dcq;+cc',1),(1,'admin','1004802015','03+8,',1),(2,'ventas','1004802015','>4,<0;',1),(3,'Jose Vera','1090001001','9-;4>4:0',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
