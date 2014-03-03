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



DROP TABLE IF EXISTS `servicios`;
DROP TABLE IF EXISTS `reparaciones`;
DROP TABLE IF EXISTS `vehiculos`;
DROP TABLE IF EXISTS `precios`;
DROP TABLE IF EXISTS `personas`;
DROP TABLE IF EXISTS `tipo_persona`;
DROP TABLE IF EXISTS `descuentos`;
DROP TABLE IF EXISTS `categorias`;



CREATE TABLE `categorias` (
  `id_categoria` INTEGER(2) NOT NULL AUTO_INCREMENT,
  `desc_categoria` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`)
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `descuentos` (
  `dia_desde` INTEGER(2) NOT NULL,
  `dia_hasta` INTEGER(2) NOT NULL,
  `porcentaje` INTEGER(2) NOT NULL,
  PRIMARY KEY USING BTREE (`dia_desde`, `dia_hasta`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `tipo_persona` (
  `id_tipo_persona` INTEGER(1) NOT NULL AUTO_INCREMENT,
  `desc_tipo_persona` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_tipo_persona`)
)ENGINE=InnoDB
AUTO_INCREMENT=3 AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `personas` (
  `tpo_DNI` VARCHAR(3) COLLATE utf8_general_ci NOT NULL,
  `nro_DNI` INTEGER(8) NOT NULL,
  `apellido` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `nombre` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `direccion` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `telefono` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `mail` VARCHAR(50) COLLATE utf8_general_ci DEFAULT NULL,
  `usuario` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `contrasenia` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `id_tipo_persona` INTEGER(1) NOT NULL,
  PRIMARY KEY USING BTREE (`tpo_DNI`, `nro_DNI`),
  UNIQUE INDEX `usuario` USING BTREE (`usuario`),
   INDEX `id_tipo_persona` USING BTREE (`id_tipo_persona`),
  CONSTRAINT `personas_fk1` FOREIGN KEY (`id_tipo_persona`) REFERENCES `tipo_persona` (`id_tipo_persona`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `precios` (
  `id_categoria` INTEGER(2) NOT NULL,
  `fecha_desde_precio` DATE NOT NULL,
  `importe` FLOAT(9,2) NOT NULL,
  PRIMARY KEY USING BTREE (`id_categoria`, `fecha_desde_precio`),
   INDEX `id_categoria` USING BTREE (`id_categoria`),
  CONSTRAINT `precios_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `vehiculos` (
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  `desc_vehiculo` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `id_categoria` INTEGER(2) NOT NULL,
  PRIMARY KEY USING BTREE (`patente`),
   INDEX `id_categoria` USING BTREE (`id_categoria`),
  CONSTRAINT `vehiculos_fk1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `reparaciones` (
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  `fec_desde` DATE NOT NULL,
  `fec_hasta` DATE NOT NULL,
  PRIMARY KEY USING BTREE (`patente`, `fec_desde`),
   INDEX `patente` USING BTREE (`patente`),
  CONSTRAINT `reparaciones_fk1` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



CREATE TABLE `servicios` (
  `nro_reserva` INTEGER(4) NOT NULL AUTO_INCREMENT,
  `fec_servicio` DATE NOT NULL,
  `fec_cancelacion` DATE DEFAULT NULL,
  `motivo_cancelacion` INTEGER(100) DEFAULT NULL,
  `tipo_DNI` VARCHAR(3) COLLATE utf8_general_ci NOT NULL,
  `nro_DNI` INTEGER(8) NOT NULL,
  `dia_desde` INTEGER(2) NOT NULL,
  `dia_hasta` INTEGER(2) NOT NULL,
  `patente` VARCHAR(6) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`nro_reserva`),
   INDEX `tipo_DNI` USING BTREE (`tipo_DNI`, `nro_DNI`),
   INDEX `dia_desde` USING BTREE (`dia_desde`, `dia_hasta`),
   INDEX `patente` USING BTREE (`patente`),
  CONSTRAINT `servicios_fk1` FOREIGN KEY (`tipo_DNI`, `nro_DNI`) REFERENCES `personas` (`tpo_DNI`, `nro_DNI`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `servicios_fk2` FOREIGN KEY (`dia_desde`, `dia_hasta`) REFERENCES `descuentos` (`dia_desde`, `dia_hasta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `servicios_fk3` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;



INSERT INTO `tipo_persona` (`id_tipo_persona`, `desc_tipo_persona`) VALUES

  (1,'Administrador'),
  (2,'Cliente');
COMMIT;



INSERT INTO `personas` (`tpo_DNI`, `nro_DNI`, `apellido`, `nombre`, `direccion`, `telefono`, `mail`, `usuario`, `contrasenia`, `id_tipo_persona`) VALUES

  ('DNI',12121212,'Del Castro','Rodrigo','Alem 5523','4111111','rdc@gmail.com','rdc','prueba',1);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
