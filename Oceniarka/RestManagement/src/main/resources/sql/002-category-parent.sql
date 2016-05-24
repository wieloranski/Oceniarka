--liquibase formatted SQL

--changeset eryk:1
SET FOREIGN_KEY_CHECKS=0;
TRUNCATE category;
SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE category
DROP COLUMN l,
DROP COLUMN r,
ADD COLUMN parent INT UNSIGNED NULL
AFTER name,
DROP INDEX l_UNIQUE,
DROP INDEX r_UNIQUE;

ALTER TABLE category
MODIFY COLUMN idcategory INT(100) UNSIGNED NOT NULL,
MODIFY COLUMN parent INT(100) UNSIGNED NOT NULL;

ALTER TABLE category
DROP INDEX idcategory_UNIQUE;

ALTER TABLE category
ADD INDEX fk_category_1_idx (parent ASC);

ALTER TABLE category
ADD CONSTRAINT fk_category_1
FOREIGN KEY (parent)
REFERENCES category (idcategory)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE category
CHANGE COLUMN idcategory idcategory INT(100) UNSIGNED NOT NULL AUTO_INCREMENT;

SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO `category` (`name`, `parent`)
VALUES ("tempus", 6), ("malesuada", 2), ("ullamcorper", 8), ("Suspendisse", 7), ("diam", 5), ("scelerisque", 1),
  ("lorem", 7), ("hendrerit", 8), ("non,", 1), ("eu", 9);
SET FOREIGN_KEY_CHECKS = 1;
