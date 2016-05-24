--liquibase formatted SQL

-- changeset eryk:69
RENAME TABLE authorities TO authority;
RENAME TABLE users TO user;
RENAME TABLE opinionvote TO opinion_vote;

--changeset eryk:70
ALTER TABLE `oceniarka`.`category`
CHANGE COLUMN `categoryId` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:71
ALTER TABLE `oceniarka`.`opinion`
CHANGE COLUMN `opinionId` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:72
ALTER TABLE `oceniarka`.`opinion_vote`
CHANGE COLUMN `opinionVoteId` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:73
ALTER TABLE `oceniarka`.`product`
CHANGE COLUMN `productId` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:74
ALTER TABLE `oceniarka`.`user`
CHANGE COLUMN `userId` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;