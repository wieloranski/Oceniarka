--liquibase formatted SQL

-- changeset eryk:63
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `addDate` `addDate` DATETIME NOT NULL;

-- changeset eryk:64
ALTER TABLE `oceniarka`.`opinion`
CHANGE COLUMN `addDate` `addDate` DATETIME NOT NULL;

-- changeset eryk:67
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `createtime` `createtime` DATETIME NOT NULL;

-- changeset eryk:68
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `lastseentime` `lastseentime` DATETIME NOT NULL;