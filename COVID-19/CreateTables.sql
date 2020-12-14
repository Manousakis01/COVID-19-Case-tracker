CREATE DATABASE Covid19;

USE Covid19;



DROP TABLE `Tested`;

CREATE TABLE `Tested` (
  `AMKA` varchar(11) default NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `dateOfBirth` DATE,
  `dateOfTest` DATE,
  `location` varchar(50) default NULL,
  `email` varchar(255) default NULL,
  `number` varchar(100) default NULL,
  PRIMARY KEY (`AMKA`)
);

CREATE TABLE Positive (
	`AMKA` varchar(11) default NULL,
    PRIMARY KEY (`AMKA`),
	FOREIGN KEY (`AMKA`) REFERENCES Tested
);



CREATE TABLE Meth (
	`AMKA` varchar(11) default NULL,
    PRIMARY KEY (`AMKA`),
	FOREIGN KEY (`AMKA`) REFERENCES Positive
);

CREATE TABLE Healed (
	`AMKA` varchar(11) default NULL,
    PRIMARY KEY (`AMKA`),
    FOREIGN KEY (`AMKA`) REFERENCES Positive
);

CREATE TABLE Death (
	`AMKA` varchar(11) default NULL,
    PRIMARY KEY (`AMKA`),
    FOREIGN KEY (`AMKA`) REFERENCES Positive
);
