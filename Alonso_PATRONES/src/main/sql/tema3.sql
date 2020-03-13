-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tema3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tema3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tema3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tema3` ;

-- -----------------------------------------------------
-- Table `tema3`.`lineas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema3`.`lineas` ;

CREATE TABLE IF NOT EXISTS `tema3`.`lineas` (
  `idlinea` INT(11) NOT NULL AUTO_INCREMENT,
  `dencorta` VARCHAR(2) NULL DEFAULT NULL,
  `denlarga` VARCHAR(45) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idlinea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tema3`.`paradas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema3`.`paradas` ;

CREATE TABLE IF NOT EXISTS `tema3`.`paradas` (
  `idparada` INT(11) NOT NULL AUTO_INCREMENT,
  `denominacion` VARCHAR(45) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idparada`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tema3`.`lineaparada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tema3`.`lineaparada` ;

CREATE TABLE IF NOT EXISTS `tema3`.`lineaparada` (
  `idlineaparada` INT(11) NOT NULL,
  `idlinea` INT(11) NULL DEFAULT NULL,
  `idparada` INT(11) NULL DEFAULT NULL,
  `marquesina` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idlineaparada`),
  INDEX `FK_linea_idx` (`idlinea` ASC) VISIBLE,
  INDEX `FK_parada_idx` (`idparada` ASC) VISIBLE,
  CONSTRAINT `FK_linea`
    FOREIGN KEY (`idlinea`)
    REFERENCES `tema3`.`lineas` (`idlinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_parada`
    FOREIGN KEY (`idparada`)
    REFERENCES `tema3`.`paradas` (`idparada`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET GLOBAL time_zone ='+1:00';
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
