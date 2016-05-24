--liquibase formatted SQL

--changeset eryk:8
ALTER TABLE `oceniarka`.`opinion`
DROP FOREIGN KEY `idproduct`,
DROP FOREIGN KEY `iduser`;

--changeset eryk:9
ALTER TABLE `oceniarka`.`opinionvote`
DROP FOREIGN KEY `idopinion`;

--changeset eryk:10
ALTER TABLE `oceniarka`.`opinion`
CHANGE COLUMN `idopinion` `opinionId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:11
ALTER TABLE opinion
CHANGE COLUMN idproduct productId INT(10) UNSIGNED NOT NULL AFTER opinionId;

--changeset eryk:12
ALTER TABLE opinion
CHANGE COLUMN iduser userId INT(10) UNSIGNED NOT NULL AFTER productId,
CHANGE COLUMN upvotes upVotes INT(10) UNSIGNED NOT NULL DEFAULT '0' ,
CHANGE COLUMN downvotes downVotes INT(10) UNSIGNED NOT NULL DEFAULT '0' ,
CHANGE COLUMN dateadd addDate DATETIME NOT NULL ,
ADD COLUMN `comment` TEXT NULL AFTER `addDate`;

--changeset eryk:13
ALTER TABLE `oceniarka`.`opinion`
ADD CONSTRAINT `idproduct`
  FOREIGN KEY (`productId`)
  REFERENCES `oceniarka`.`product` (`idproduct`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `iduser`
  FOREIGN KEY (`userId`)
  REFERENCES `oceniarka`.`user` (`iduser`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:14
INSERT INTO `oceniarka`.`product` (`idproduct`, `idcategory`, `productname`, `productrating`) VALUES ('1', '1', 'Opel', '3');

--changeset eryk:15
INSERT INTO opinion (productId,userId,rating,upVotes,downVotes,addDate,comment) VALUES
    (1,1,6,7,2,"2015-07-06 05:54:35","vitae diam. Proin dolor. Nulla semper"),
    (1,2,5,10,7,"2015-08-28 14:30:40","felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem"),
    (1,3,4,9,9,"2015-01-28 11:29:22","Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent"),
    (1,4,6,8,5,"2016-04-21 01:36:30","Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae"),
    (1,5,10,8,10,"2016-05-16 03:06:11","in consequat enim diam vel arcu. Curabitur ut odio vel est tempor bibendum."),
    (1,6,2,7,2,"2014-12-14 07:49:38","eros. Proin ultrices. Duis volutpat"),
    (1,7,6,5,10,"2015-04-24 00:54:24","egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed"),
    (1,8,9,9,5,"2015-12-03 09:10:30","sodales elit erat vitae risus. Duis"),
    (1,9,9,2,10,"2016-06-18 14:54:49","nunc ac mattis ornare, lectus ante dictum mi, ac mattis"),
    (1,10,5,10,10,"2015-12-16 08:16:03","arcu. Vestibulum ante ipsum primis in faucibus");
