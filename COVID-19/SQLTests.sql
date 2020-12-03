create database population;
use population;

CREATE TABLE Tests (
result VARCHAR(50) PRIMARY KEY,
date DATETIME;
id int, 
CONSTRAINT FKT FOREIGN KEY (id) REFERENCES Citizens;


