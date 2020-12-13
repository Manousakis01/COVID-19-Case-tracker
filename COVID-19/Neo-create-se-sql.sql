CREATE DATABASE Covid19;

USE Covid19;



DROP TABLE `Tested`;

CREATE TABLE `Tested` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `AMKA` varchar(11) default NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `dateOfBirth` varchar(255),
  `dateOfTest` varchar(255),
  `location` varchar(50) default NULL,
  `email` varchar(255) default NULL,
  `number` varchar(100) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

CREATE TABLE positives (
	`AMKA` varchar(11) default NULL
) 



CREATE TABLE Meths (
	`AMKA` varchar(11) default NULL
)

CREATE TABLE Healed (
	`AMKA` varchar(11) default NULL
)

CREATE TABLE Deaths (
	`AMKA` varchar(11) default NULL
)
