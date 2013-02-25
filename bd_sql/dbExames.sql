# SQL Manager 2007 for MySQL 4.3.4.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : dbExames


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `dbExames`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `dbexames`;


#
# Structure for the `usuario` table : 
#

CREATE TABLE `usuario` (
  `nome` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL,
  `senha` VARCHAR(50) COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`nome`)
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';

#
# Structure for the `exame` table : 
#

CREATE TABLE `exame` (
  `idExame` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(40) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `valor` FLOAT(9,3) NOT NULL,
  PRIMARY KEY (`idExame`)
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';

#
# Structure for the `medico` table : 
#

CREATE TABLE `medico` (
  `idMedico` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `crm` VARCHAR(15) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`idMedico`)
)ENGINE=InnoDB
CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';

#
# Structure for the `paciente` table : 
#

CREATE TABLE `paciente` (
  `idPaciente` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `dataNasc` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
  `logradouro` VARCHAR(60) COLLATE latin1_swedish_ci DEFAULT NULL,
  `numero` VARCHAR(10) COLLATE latin1_swedish_ci DEFAULT NULL,
  `bairro` VARCHAR(60) COLLATE latin1_swedish_ci DEFAULT NULL,
  `cidade` VARCHAR(60) COLLATE latin1_swedish_ci DEFAULT NULL,
  `uf` VARCHAR(2) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';

#
# Structure for the `agenda` table : 
#

CREATE TABLE `agenda` (
  `dataHora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idMedico` INTEGER(11) NOT NULL,
  `idExame` INTEGER(11) NOT NULL,
  `idPaciente` INTEGER(11) NOT NULL,
  `obs` TEXT COLLATE latin1_swedish_ci,
  `resultado` TEXT COLLATE latin1_swedish_ci,
  PRIMARY KEY (`dataHora`, `idMedico`, `idExame`, `idPaciente`),
  KEY `FK_MEDICO_AGENDA` (`idMedico`),
  KEY `FK_EXAME_AGENDA` (`idExame`),
  KEY `FK_PAC_AGENDA` (`idPaciente`),
  CONSTRAINT `FK_MEDICO_AGENDA` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`),
  CONSTRAINT `FK_EXAME_AGENDA` FOREIGN KEY (`idExame`) REFERENCES `exame` (`idExame`),
  CONSTRAINT `FK_PAC_AGENDA` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`)
)ENGINE=InnoDB
CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;