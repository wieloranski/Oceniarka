--liquibase formatted SQL

--changeset rafal:1
DROP TABLE IF EXISTS `oceniarka`.`authorities` ;

--changeset rafal:2
DROP TABLE IF EXISTS `oceniarka`.`users` ;

--changeset rafal:4
CREATE TABLE IF NOT EXISTS `oceniarka`.`users` (
  `username` VARCHAR(255) NOT NULL UNIQUE COMMENT '',
  `password` VARCHAR(255) NOT NULL COMMENT '',
  `enabled` bool NOT NULL DEFAULT TRUE COMMENT '',
  `deleted` bool NOT NULL DEFAULT FALSE COMMENT '',
  `createtime` DATETIME NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '',
  `lastseentime` DATETIME NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '',
  PRIMARY KEY (`username`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

--changeset rafal:5
CREATE TABLE IF NOT EXISTS `oceniarka`.`authorities` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(255) NOT NULL UNIQUE COMMENT '',
  `authority` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `username`
    FOREIGN KEY (`username`)
    REFERENCES `oceniarka`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
