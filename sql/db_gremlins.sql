/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 5.6.22-log : Database - db_gremlins
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_gremlins` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_gremlins`;

/*Table structure for table `guia` */

DROP TABLE IF EXISTS `guia`;

CREATE TABLE `guia` (
  `idGuia` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `NID_Guia` varchar(45) NOT NULL,
  `ClaseUsuario` varchar(45) NOT NULL,
  `EstadoGuia` varchar(45) NOT NULL,
  `Origen` varchar(45) NOT NULL,
  `Destino` varchar(45) NOT NULL,
  `Fecha_Cancelacion` datetime NOT NULL,
  `Fecha_Entrega` datetime NOT NULL,
  PRIMARY KEY (`idGuia`),
  UNIQUE KEY `idGuia_UNIQUE` (`idGuia`),
  KEY `idUsuario_idx` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `guia` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `Proveedor` varchar(45) NOT NULL,
  `NID_Proveedor` int(11) NOT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `Precio Compra` int(11) DEFAULT NULL,
  `Precio_Venta` int(11) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idProducto_UNIQUE` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `producto` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Numero_Identificacion` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `Cargo` varchar(45) NOT NULL,
  `Tipo_Usuario` varchar(45) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  UNIQUE KEY `Numero_Identificacion_UNIQUE` (`Numero_Identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`idUsuario`,`Numero_Identificacion`,`Nombre`,`Apellido`,`Telefono`,`Direccion`,`Correo`,`Cargo`,`Tipo_Usuario`,`Password`) values 
(1,88031585,'Juan Carlos','Carvajal',31252377,'Cll 21','juan.carvajal-ro@uniminuto.edu.co','Administrador','Administrador','88031585');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
