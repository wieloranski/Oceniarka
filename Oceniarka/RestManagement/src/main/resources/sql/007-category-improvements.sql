--liquibase formatted SQL

--changeset eryk:22
ALTER TABLE `oceniarka`.`product`
DROP FOREIGN KEY `idcategory`;

--changeset eryk:23
ALTER TABLE `oceniarka`.`category`
DROP FOREIGN KEY `fk_category_1`,
DROP INDEX fk_category_1_idx;

--changeset eryk:24
ALTER TABLE `oceniarka`.`category`
CHANGE COLUMN `idcategory` `categoryId` INT(100) UNSIGNED NOT NULL AUTO_INCREMENT ;

--changeset eryk:25
ALTER TABLE `oceniarka`.`category`
ADD INDEX `fk_category_1_idx` (`parent` ASC);
ALTER TABLE `oceniarka`.`category`
ADD CONSTRAINT `fk_category_1`
  FOREIGN KEY (`parent`)
  REFERENCES `oceniarka`.`category` (`categoryId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset eryk:27
ALTER TABLE `oceniarka`.`product`
ADD CONSTRAINT `fk_product_1`
FOREIGN KEY (`categoryId`)
REFERENCES `oceniarka`.`category` (`categoryId`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;