--liquibase formatted SQL

--changeset eryk:25
ALTER TABLE `oceniarka`.`opinionvote`
DROP FOREIGN KEY `iduser2`;
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `idopinion` `opinionVoteId` INT(10) UNSIGNED NOT NULL ,
CHANGE COLUMN `iduser` `userId` INT(10) UNSIGNED NOT NULL ,
CHANGE COLUMN `updow` `upDown` INT(10) UNSIGNED NOT NULL ;
ALTER TABLE `oceniarka`.`opinionvote`
ADD CONSTRAINT `iduser2`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`user` (`iduser`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:28
ALTER TABLE `oceniarka`.`opinionvote`
CHANGE COLUMN `opinionVoteId` `opinionVoteId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:29
INSERT INTO opinionvote (userId,upDown) VALUES (1,7),(1,1),(1,1),(1,10),(1,2),(1,5),(1,9),(1,4),(1,2),(1,2);