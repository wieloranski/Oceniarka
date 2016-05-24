--liquibase formatted SQL

--changeset eryk:3
ALTER TABLE `oceniarka`.`user`
CHANGE COLUMN `lastseentime` `lastlogintime` DATETIME NOT NULL DEFAULT '1900-01-01 00:00:00',
ADD COLUMN `name` VARCHAR(45) NOT NULL
AFTER `iduser`,
ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC);

--changest eryk:4
ALTER TABLE `oceniarka`.`user`
CHANGE COLUMN `password` `password` VARCHAR(255)
CHARACTER SET 'utf8'
COLLATE 'utf8_bin' NOT NULL;

--changest eryk:5
ALTER TABLE `oceniarka`.`user`
DROP FOREIGN KEY `type`;

--changeset eryk:6
DROP TABLE `oceniarka`.`useraccounttype`;

--changeset eryk:7
INSERT INTO `user` (`type`, `email`, `password`, `createtime`, `lastlogintime`, `name`) VALUES
  (3, "id.libero.Donec@velitduisemper.edu", "d033e22ae348aeb5660fc2140aec35850c4da997", "2015-03-09 19:14:34",
   "2015-02-15 11:57:14", "admin"),
  (3, "magna.tellus@a.org", "27d49d5dbe73b65b914d0b1687a345e2dd67fba9", "2015-02-25 05:55:17", "2016-07-13 04:04:48",
   "Christian"),
  (3, "et.magnis@Donecestmauris.com", "a2e23b3ebb4145fae89db4f9725216623da67548", "2016-08-05 05:55:38",
   "2015-08-19 09:07:58", "Brennan"),
  (1, "conubia.nostra@ligula.ca", "f1cec2563722b9c8cde385d416ebb08d8eb3f48d", "2016-06-22 09:00:13",
   "2015-01-14 15:18:41", "Sloane"),
  (1, "ac@aliquetProin.co.uk", "d88859cc36ce9b89588ca7f960969036244988f1", "2016-08-14 17:55:35", "2014-12-13 12:32:38",
   "Drew"),
  (2, "natoque.penatibus.et@Quisquetinciduntpede.net", "9b27b8c3b526cd04f6f902af66f7374ad46aedb5",
   "2015-09-27 18:35:24", "2016-06-08 12:52:47", "Libby"),
  (2, "viverra@Sedneque.ca", "556d9a3f48d924dbe6e5110cddc52c39fb4c17f2", "2016-07-28 15:17:35", "2015-03-09 10:56:45",
   "Karly"),
  (1, "Nulla.tempor@quamCurabitur.com", "6056ddb419f2fb3ccc0a8b608d1788e03e519dfe", "2015-06-26 06:09:16",
   "2016-11-24 08:40:02", "Rowan"),
  (3, "erat.Etiam.vestibulum@dictum.ca", "b5e016461e6854e4e71c5dcbaf0bf906803336cb", "2015-10-27 04:59:15",
   "2015-05-19 23:44:33", "Miranda"),
  (3, "sed.est.Nunc@sodalesMauris.net", "edf0fbb53f84d72975400f023818a689fdf3865f", "2016-11-15 16:12:59",
   "2016-01-30 14:24:49", "Freya");
