use CovidDB;
CREATE TABLE IF NOT EXISTS Tested AS SELECT SSN, firstName, lastName, dateOfBirth, dateOfTest, location, email, number FROM preTested;

INSERT Tested
SELECT SSN, firstName, lastName, dateOfBirth, dateOfTest, location, email, number FROM preTested ;
