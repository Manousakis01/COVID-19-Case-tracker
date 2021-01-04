USE CovidDB;
/*
DROP TABLE Meth;
DROP TABLE Healed;
DROP TABLE Death;
DROP TABLE Positive;
DROP TABLE Tested;*/

CREATE TABLE preTested (
	partSSN char (4) not null,
	SSN varchar(12) generated always as (CONCAT(DATE_FORMAT((dateOfBirth),'%d'),
		DATE_FORMAT((DateOfBirth),'%m'),DATE_FORMAT((dateOfBirth),'%Y'),partSSN)) not null,
	firstName varchar(255) default NULL,
	lastName varchar(255) default NULL,
	dateOfBirth DATE not null,
	dateOfTest DATE not null,
	location varchar(50) default NULL,
	email varchar(255) default NULL,
	number varchar(100) default NULL
);

CREATE TABLE Positive (
	SSN varchar(11) NOT NULL,
    PRIMARY KEY (SSN)
);
CREATE TABLE Meth (
	SSN varchar(11) NOT NULL,
<<<<<<< HEAD
	dateOfMeth date not null,
=======
    dateOfInsertion DATE,
>>>>>>> 79c1a225ad7dd0e51d1ed776051d80422993d5cf
    PRIMARY KEY (SSN)
);
CREATE TABLE Healed (
	SSN varchar(11) NOT NULL,

     dateOfHealed date not null,
=======
    dateOfHeal DATE,
>>>>>>> 79c1a225ad7dd0e51d1ed776051d80422993d5cf
    PRIMARY KEY (SSN)
);
CREATE TABLE Death (
	SSN varchar(11) NOT NULL,
<<<<<<< HEAD
    dateOfDeath date not NULL,
=======
    dateOfDeath DATE,
>>>>>>> 79c1a225ad7dd0e51d1ed776051d80422993d5cf
    PRIMARY KEY (SSN)
);
