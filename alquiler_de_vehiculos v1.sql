# SQL Manager Lite for MySQL 5.4.2.43077
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : alquiler_de_vehiculos


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `alquiler_de_vehiculos`;

CREATE DATABASE `alquiler_de_vehiculos`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `alquiler_de_vehiculos`;

#
# Dropping database objects
#

DROP TABLE IF EXISTS `servicios`;
DROP TABLE IF EXISTS `reparaciones`;
DROP TABLE IF EXISTS `vehiculos`;
DROP TABLE IF EXISTS `precios`;
DROP TABLE IF EXISTS `descuentos`;
DROP TABLE IF EXISTS `clientes`;
DROP TABLE IF EXISTS `categorias`;

#
# Structure for the `categorias` table : 
#

CREATE TABLE `categorias` (
  `id_categoria` INTEGER(2) NOT NULL,
  `desc_categoria` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`) COMMENT ''
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `clientes` table : 
#

CREATE TABLE `clientes` (
  `tpo_DNI` VARCHAR(3) COLLATE utf8_general_ci NOT NULL,
  `nro_DNI` INTEGER(8) NOT NULL,
  `apellido` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `nombre` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `direccion` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `telefono` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `mail` VARCHAR(50) COLLATE utf8_general_ci DEFAULT NULL,
  `usuario` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `contrasenia` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`tpo_DNI`, `nro_DNI`) COMMENT ''
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `descuentos` table : 
#

CREATE TABLE `descuentos` (
  `dia_desde` INTEGER(2) NOT NULL,
  `dia_hasta` INTEGER(2) NOT NULL,
  `descuento` INTEGER(2) NOT NULL,
  PRIMARY KEY USING BTREE (`dia_desde`, `dia_hasta`) COMMENT ''
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `precios` table : 
#

CREATE TABLE `precios` (
  `id_categoria` INTEGER(2) NOT NULL,
  `fecha_desde_precio` DATE NOT NULL,
  `importe` FLOAT(9,3) NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`, `fecha_desde_precio`) COMMENT '',
   INDEX `id_categoria` USING BTREE (`id_categoria`) COMMENT '',
  CONSTRAINT `precios_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `vehiculos` table : 
#

CREATE TABLE `vehiculos` (
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  `desc_vehiculo` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `id_categoria` INTEGER(2) NOT NULL,
  PRIMARY KEY USING BTREE (`patente`) COMMENT '',
   INDEX `id_categoria` USING BTREE (`id_categoria`) COMMENT '',
  CONSTRAINT `vehiculos_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `reparaciones` table : 
#

CREATE TABLE `reparaciones` (
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  `fec_desde` DATE NOT NULL,
  `fec_hasta` DATE NOT NULL,
  PRIMARY KEY USING BTREE (`patente`, `fec_desde`) COMMENT '',
   INDEX `patente` USING BTREE (`patente`) COMMENT '',
  CONSTRAINT `reparaciones_fk1` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `servicios` table : 
#

CREATE TABLE `servicios` (
  `nro_reserva` INTEGER(11) NOT NULL,
  `fec_servicio` DATE NOT NULL,
  `fec_cancelacion` DATE DEFAULT NULL,
  `motivo_cancelacion` INTEGER(50) DEFAULT NULL,
  `tipo_DNI` VARCHAR(3) COLLATE utf8_general_ci NOT NULL,
  `nro_DNI` INTEGER(8) NOT NULL,
  `dia_desde` INTEGER(2) NOT NULL,
  `dia_hasta` INTEGER(2) NOT NULL,
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`nro_reserva`) COMMENT '',
   INDEX `tipo_DNI` USING BTREE (`tipo_DNI`, `nro_DNI`) COMMENT '',
   INDEX `dia_desde` USING BTREE (`dia_desde`, `dia_hasta`) COMMENT '',
   INDEX `patente` USING BTREE (`patente`) COMMENT '',
  CONSTRAINT `servicios_fk2` FOREIGN KEY (`dia_desde`, `dia_hasta`) REFERENCES `descuentos` (`dia_desde`, `dia_hasta`),
  CONSTRAINT `servicios_fk1` FOREIGN KEY (`tipo_DNI`, `nro_DNI`) REFERENCES `clientes` (`tpo_DNI`, `nro_DNI`),
  CONSTRAINT `servicios_fk3` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
