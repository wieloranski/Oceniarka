--liquibase formatted SQL

--changeset eryk:2
ALTER TABLE `oceniarka`.`category`
DROP FOREIGN KEY `fk_category_1`;
ALTER TABLE `oceniarka`.`category`
CHANGE COLUMN `parent` `parent` INT(100) UNSIGNED NULL;
ALTER TABLE `oceniarka`.`category`
ADD CONSTRAINT `fk_category_1`
FOREIGN KEY (`parent`)
REFERENCES `oceniarka`.`category` (`idcategory`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE category;
INSERT INTO `category` (`name`, `parent`) VALUES
  ("tempus", NULL),
  ("malesuada", 1),
  ("ullamcorper", 2),
  ("Suspendisse", 2),
  ("diam", 2),
  ("scelerisque", 1),
  ("lorem", 6),
  ("hendrerit", 7),
  ("non,", 6),
  ("eu", 6);
SET FOREIGN_KEY_CHECKS = 1;
