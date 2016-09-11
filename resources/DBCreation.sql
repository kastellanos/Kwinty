-- MySQL Script generated by MySQL Workbench
-- 09/10/16 20:11:07
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema kwinty
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kwinty` ;

-- -----------------------------------------------------
-- Schema kwinty
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kwinty` DEFAULT CHARACTER SET utf8 ;
USE `kwinty` ;

-- -----------------------------------------------------
-- Table `kwinty`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`User` (
  `username` CHAR(25) NOT NULL,
  `id_type` CHAR(6) NOT NULL,
  `role` CHAR(6) NOT NULL,
  `name` CHAR(50) NOT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_User_Credentials1_idx` (`username` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Credentials` (
  `username` CHAR(25) NOT NULL,
  `password` CHAR(45) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_Credentials_User1_idx` (`username` ASC),
  CONSTRAINT `fk_Credentials_User1`
    FOREIGN KEY (`username`)
    REFERENCES `kwinty`.`User` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Admin` (
  `username` CHAR(25) NOT NULL,
  `branch_office` VARCHAR(45) NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_Admin_User1_idx` (`username` ASC),
  CONSTRAINT `fk_Admin_User1`
    FOREIGN KEY (`username`)
    REFERENCES `kwinty`.`User` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Client` (
  `username` CHAR(25) NOT NULL,
  `phonenumber` INT(10) NOT NULL,
  `email` CHAR(50) NOT NULL,
  `address` CHAR(50) NULL DEFAULT NULL,
  `payment_capacity` FLOAT NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_Client_User1_idx1` (`username` ASC),
  CONSTRAINT `fk_Client_User1`
    FOREIGN KEY (`username`)
    REFERENCES `kwinty`.`User` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Product` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `type` CHAR(12) NOT NULL,
  `fee_type` CHAR(12) NOT NULL,
  `interest_type` CHAR(12) NOT NULL,
  `max_number_fees` INT NOT NULL,
  `interest_rate` FLOAT NOT NULL,
  `description` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Acquiredproduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Acquiredproduct` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `Product_id` BIGINT(19) NOT NULL,
  `username_id` CHAR(25) NOT NULL,
  `number_fees` INT NOT NULL,
  `amount` FLOAT NOT NULL,
  `fee_amount` FLOAT NOT NULL,
  `amount_paid` FLOAT NOT NULL,
  `reference` CHAR(50) NULL DEFAULT NULL,
  `acquisition_date` DATE NOT NULL,
  `fee_increment_rate` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Acquiredproduct_Product1_idx` (`Product_id` ASC),
  INDEX `fk_Acquiredproduct_Client1_idx` (`username_id` ASC),
  CONSTRAINT `fk_Acquiredproduct_Product1`
    FOREIGN KEY (`Product_id`)
    REFERENCES `kwinty`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acquiredproduct_Client1`
    FOREIGN KEY (`username_id`)
    REFERENCES `kwinty`.`Client` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kwinty`.`Payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kwinty`.`Payment` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `amount` FLOAT NOT NULL,
  `Acquiredproduct` BIGINT(19) NOT NULL,
  `Admin_username` CHAR(25) NOT NULL,
  PRIMARY KEY (`id`, `Acquiredproduct`, `Admin_username`),
  INDEX `fk_Payment_Acquiredproduct1_idx` (`Acquiredproduct` ASC),
  INDEX `fk_Payment_Admin1_idx` (`Admin_username` ASC),
  CONSTRAINT `fk_Payment_Acquiredproduct1`
    FOREIGN KEY (`Acquiredproduct`)
    REFERENCES `kwinty`.`Acquiredproduct` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Admin1`
    FOREIGN KEY (`Admin_username`)
    REFERENCES `kwinty`.`Admin` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
