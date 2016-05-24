--liquibase formatted SQL

--changeset rafal:30
drop table if exists opinionvote

--changeset rafal:31
CREATE TABLE `oceniarka`.`opinionvote` (
  `usernameref` VARCHAR(50) NOT NULL,
  `opinionid` INT(10) UNSIGNED NOT NULL,
  `upDown` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`opinionid`, `usernameref`),
  INDEX `opinion_idx` (`opinionid` ASC),
  UNIQUE INDEX `username_UNIQUE` (`usernameref` ASC),
  UNIQUE INDEX `opinionid_UNIQUE` (`opinionid` ASC),
  CONSTRAINT `opinion`
    FOREIGN KEY (`opinionid`)
    REFERENCES `oceniarka`.`opinion` (`opinionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--changeset rafal:32
ALTER TABLE `oceniarka`.`opinion`
  DROP FOREIGN KEY `iduser`,
  DROP INDEX `iduser_idx`,
  DROP COLUMN `userId`,
  ADD COLUMN `username` VARCHAR(255) NOT NULL AFTER `comment` ;

--changeset rafal:33
drop table user