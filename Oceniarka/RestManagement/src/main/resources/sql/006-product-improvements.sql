--liquibase formatted SQL

--changeset eryk:16
ALTER TABLE `oceniarka`.`product`
DROP FOREIGN KEY `idcategory`;

--changeset eryk:17
ALTER TABLE `oceniarka`.`opinion`
DROP FOREIGN KEY `idproduct`;

--changeset eryk:18
ALTER TABLE `oceniarka`.`product`
CHANGE COLUMN `idproduct` `productId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `idcategory` `categoryId` INT(10) UNSIGNED NOT NULL ,
CHANGE COLUMN `productname` `productName` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL ,
CHANGE COLUMN `productrating` `productRating` INT(11) NOT NULL DEFAULT '0' ;

--changeset eryk:19
ALTER TABLE `oceniarka`.`product`
ADD CONSTRAINT `idcategory`
  FOREIGN KEY (`categoryId`)
  REFERENCES `oceniarka`.`category` (`idcategory`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:20
ALTER TABLE opinion
ADD CONSTRAINT productId_fk
    FOREIGN KEY (productId)
    REFERENCES product (productId);

--changeset eryk:21
INSERT INTO product (categoryId,productName,productRating) VALUES (9,"Donec Feugiat Corporation",5);
INSERT INTO product (categoryId,productName,productRating) VALUES (7,"Lobortis Mauris Ltd",2);
INSERT INTO product (categoryId,productName,productRating) VALUES (9,"Non Lobortis Quis PC",5);
INSERT INTO product (categoryId,productName,productRating) VALUES (2,"Nunc Incorporated",3);
INSERT INTO product (categoryId,productName,productRating) VALUES (3,"Enim Suspendisse Aliquet LLC",6);
INSERT INTO product (categoryId,productName,productRating) VALUES (3,"Arcu Et LLC",2);
INSERT INTO product (categoryId,productName,productRating) VALUES (2,"Dictum Eleifend Limited",1);
INSERT INTO product (categoryId,productName,productRating) VALUES (10,"Nulla Facilisi PC",6);
INSERT INTO product (categoryId,productName,productRating) VALUES (9,"Pede Company",5);
INSERT INTO product (categoryId,productName,productRating) VALUES (10,"Nec Foundation",1);
INSERT INTO product (categoryId,productName,productRating) VALUES (1,"Tempor Erat Inc.",7);
INSERT INTO product (categoryId,productName,productRating) VALUES (10,"Mi Ac Limited",10);
INSERT INTO product (categoryId,productName,productRating) VALUES (5,"In Industries",1);