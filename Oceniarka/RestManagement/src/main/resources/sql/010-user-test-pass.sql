--liquibase formatted SQL

-- changeset eryk:44
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `createtime` `createtime` DATETIME NOT NULL DEFAULT '1900-01-01 00:00:00' ,
CHANGE COLUMN `lastseentime` `lastseentime` DATETIME NOT NULL DEFAULT '1900-01-01 00:00:00' ;

-- changeset eryk:45
DROP TABLE IF EXISTS test;

-- changeset eryk:46
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `lastseentime` `lastseentime` VARCHAR(45) NOT NULL DEFAULT '1900-01-01 00:00:00.000' ,
ADD COLUMN `userId` INT UNSIGNED NOT NULL AUTO_INCREMENT FIRST,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`userId`),
ADD UNIQUE INDEX `userId_UNIQUE` (`userId` ASC);

--changeset eryk:47
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `userId` `userId` INT(10) UNSIGNED NOT NULL ;

SET @count = 0;
UPDATE `users` SET `users`.`userId` = @count:= @count + 1;

--changeset eryk:48
ALTER TABLE `oceniarka`.`users`
CHANGE COLUMN `userId` `userId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:49
ALTER TABLE `oceniarka`.`opinion`
DROP COLUMN `username`,
ADD COLUMN `userId` INT UNSIGNED NOT NULL DEFAULT 1 AFTER `opinionId`,
ADD INDEX `fk_opinion_1_idx` (`userId` ASC);
ALTER TABLE `oceniarka`.`opinion`
ADD CONSTRAINT `fk_opinion_1`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`users` (`userId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:50
ALTER TABLE `oceniarka`.`opinionvote`
DROP COLUMN `usernameref`,
ADD COLUMN `opinionVoteId` INT UNSIGNED NOT NULL FIRST,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`opinionid`, `opinionVoteId`),
DROP INDEX `username_UNIQUE` ;

--changeset eryk:51
ALTER TABLE `oceniarka`.`opinion`
DROP FOREIGN KEY `fk_opinion_1`;
ALTER TABLE `oceniarka`.`opinion`
CHANGE COLUMN `userId` `userId` INT(10) UNSIGNED NOT NULL ;
ALTER TABLE `oceniarka`.`opinion`
ADD CONSTRAINT `fk_opinion_1`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`users` (`userId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:52
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `opinionVoteId` `opinionVoteId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`opinionVoteId`);

--changeset eryk:53
SET @count = 0;
UPDATE opinion SET opinionId = @count:= @count + 1;

--changeset eryk:54
ALTER TABLE `oceniarka`.`opinionvote`
DROP INDEX `opinionid_UNIQUE` ;

--changeset eryk:55
INSERT INTO opinionvote (opinionId,upDown) VALUES (1,7),(1,1),(1,1),(1,10),(1,2),(1,5),(1,9),(1,4),(1,2),(1,2);

--changeset eryk:56
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `opinionVoteId` `opinionVoteId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `upDown` `upDown` INT NOT NULL ,
ADD COLUMN `userId` INT UNSIGNED NOT NULL DEFAULT 1 AFTER `opinionVoteId`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`opinionVoteId`);

--changeset eryk:57
ALTER TABLE `oceniarka`.`opinionvote`
ADD CONSTRAINT `fk_opinionvote_1`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`users` (`userId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:58
ALTER TABLE `oceniarka`.`opinionvote`
DROP FOREIGN KEY `fk_opinionvote_1`;
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `userId` `userId` INT(10) UNSIGNED NOT NULL ;
ALTER TABLE `oceniarka`.`opinionvote`
ADD CONSTRAINT `fk_opinionvote_1`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`users` (`userId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:59
SET @count = 0;
UPDATE `opinionvote` SET `opinionVoteId` = @count:= @count + 1;

--changeset eryk:60
ALTER TABLE `oceniarka`.`opinionvote`
DROP FOREIGN KEY `fk_opinionvote_1`;

--changeset eryk:61
ALTER TABLE `oceniarka`.`opinionvote`
DROP COLUMN `userId`,
DROP INDEX `fk_opinionvote_1` ;

--changeset eryk:62
ALTER TABLE `oceniarka`.`opinionvote`
ADD COLUMN `addDate` DATETIME NOT NULL AFTER `upDown`;
