# SQL Manager Lite for MySQL 5.4.2.43077
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : alquiler_de_vehiculos


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

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
DROP TABLE IF EXISTS `personas`;
DROP TABLE IF EXISTS `tipos_persona`;
DROP TABLE IF EXISTS `descuentos`;
DROP TABLE IF EXISTS `categorias`;

#
# Structure for the `categorias` table : 
#

CREATE TABLE `categorias` (
  `id_categoria` INTEGER(2) NOT NULL AUTO_INCREMENT,
  `desc_categoria` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=9 AVG_ROW_LENGTH=2048 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `descuentos` table : 
#

CREATE TABLE `descuentos` (
  `id_descuento` INTEGER(2) NOT NULL AUTO_INCREMENT,
  `dia_desde` INTEGER(2) NOT NULL,
  `dia_hasta` INTEGER(2) NOT NULL,
  `porcentaje` INTEGER(2) NOT NULL,
  PRIMARY KEY USING BTREE (`id_descuento`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=5 AVG_ROW_LENGTH=4096 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `tipos_persona` table : 
#

CREATE TABLE `tipos_persona` (
  `id_tipo_persona` INTEGER(1) NOT NULL AUTO_INCREMENT,
  `desc_tipo_persona` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_tipo_persona`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=3 AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `personas` table : 
#

CREATE TABLE `personas` (
  `DNI` CHAR(8) COLLATE utf8_general_ci NOT NULL,
  `apellido` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `nombre` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `direccion` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `telefono` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `mail` VARCHAR(50) COLLATE utf8_general_ci DEFAULT NULL,
  `usuario` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `contrasenia` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `id_tipo_persona` INTEGER(1) NOT NULL,
  PRIMARY KEY USING BTREE (`DNI`) COMMENT '',
  UNIQUE INDEX `usuario` USING BTREE (`usuario`) COMMENT '',
   INDEX `id_tipo_persona` USING BTREE (`id_tipo_persona`) COMMENT '',
  CONSTRAINT `personas_fk1` FOREIGN KEY (`id_tipo_persona`) REFERENCES `tipos_persona` (`id_tipo_persona`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
AVG_ROW_LENGTH=16384 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `precios` table : 
#

CREATE TABLE `precios` (
  `id_categoria` INTEGER(2) NOT NULL,
  `fecha_desde_precio` DATE NOT NULL,
  `importe` FLOAT(9,2) NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`, `fecha_desde_precio`) COMMENT '',
   INDEX `id_categoria` USING BTREE (`id_categoria`) COMMENT '',
  CONSTRAINT `precios_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
AVG_ROW_LENGTH=2048 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
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
  CONSTRAINT `vehiculos_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
AVG_ROW_LENGTH=16384 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
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
  CONSTRAINT `reparaciones_fk1` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `servicios` table : 
#

CREATE TABLE `servicios` (
  `nro_reserva` INTEGER(4) NOT NULL AUTO_INCREMENT,
  `fec_servicio` DATE NOT NULL,
  `fec_cancelacion` DATE DEFAULT NULL,
  `motivo_cancelacion` VARCHAR(100) COLLATE utf8_general_ci DEFAULT NULL,
  `DNI` CHAR(8) COLLATE utf8_general_ci NOT NULL,
  `id_descuento` INTEGER(2) NOT NULL,
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`nro_reserva`) COMMENT '',
   INDEX `patente` USING BTREE (`patente`) COMMENT '',
   INDEX `DNI` USING BTREE (`DNI`) COMMENT '',
   INDEX `id_descuento` USING BTREE (`id_descuento`) COMMENT '',
  CONSTRAINT `servicios_fk2` FOREIGN KEY (`id_descuento`) REFERENCES `descuentos` (`id_descuento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `servicios_fk1` FOREIGN KEY (`DNI`) REFERENCES `personas` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `servicios_fk3` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Data for the `categorias` table  (LIMIT -491,500)
#

INSERT INTO `categorias` (`id_categoria`, `desc_categoria`) VALUES

  (1,'Turismo Hatchback 3 Puertas'),
  (2,'Turismo Hatchback 5 Puertas'),
  (3,'Turismo Sedán'),
  (4,'Deportivo'),
  (5,'Monovolumen'),
  (6,'SUV'),
  (7,'Furgoneta'),
  (8,'Camioneta');
COMMIT;

#
# Data for the `descuentos` table  (LIMIT -495,500)
#

INSERT INTO `descuentos` (`id_descuento`, `dia_desde`, `dia_hasta`, `porcentaje`) VALUES

  (1,0,9,0),
  (2,10,29,5),
  (3,30,60,10),
  (4,60,365,15);
COMMIT;

#
# Data for the `tipos_persona` table  (LIMIT -497,500)
#

INSERT INTO `tipos_persona` (`id_tipo_persona`, `desc_tipo_persona`) VALUES

  (1,'Administrador'),
  (2,'Cliente');
COMMIT;

#
# Data for the `personas` table  (LIMIT -498,500)
#

INSERT INTO `personas` (`DNI`, `apellido`, `nombre`, `direccion`, `telefono`, `mail`, `usuario`, `contrasenia`, `id_tipo_persona`) VALUES

  ('12312312','Pereta','Pr las','Testeo 3','5554443','lpereta@gmail.com','jmedez','hola',1);
COMMIT;

#
# Data for the `precios` table  (LIMIT -491,500)
#

INSERT INTO `precios` (`id_categoria`, `fecha_desde_precio`, `importe`) VALUES

  (1,'2014-03-01',400.00),
  (2,'2014-03-01',450.00),
  (3,'2014-03-01',750.00),
  (4,'2014-03-01',3000.00),
  (5,'2014-03-01',850.00),
  (6,'2014-03-01',800.00),
  (7,'2014-03-01',500.00),
  (8,'2014-03-01',2000.00);
COMMIT;

#
# Data for the `vehiculos` table  (LIMIT -498,500)
#

INSERT INTO `vehiculos` (`patente`, `desc_vehiculo`, `id_categoria`) VALUES

  ('FPP787','Peugeot 207 XR Premium',1);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
