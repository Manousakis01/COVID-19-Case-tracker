use CovidDB;

insert into Positive 
select Tested.SSN
from Tested
order by RAND()
limit 73;

INSERT INTO Healed (SSN, dateOfHealed)
SELECT Positive.SSN, DATE_ADD(Tested.dateOfTest, Interval + CAST(RAND() * (3)+10 AS UNSIGNED) day)
FROM Tested 
INNER JOIN Positive  ON Positive.SSN = Tested.SSN
order by rand()
limit 36

INSERT INTO Death (SSN, dateOfDeath)
SELECT Meth.SSN, DATE_ADD(Tested.dateOfTest, Interval + CAST(RAND() * (4)+9 AS UNSIGNED) day)
FROM Tested 
INNER JOIN Meth  ON Meth.SSN = Tested.SSN
order by rand()
limit 6;

INSERT INTO Meth (SSN, dateOfMeth)
SELECT Positive.SSN, DATE_ADD(Tested.dateOfTest, Interval + CAST(RAND() * (3)+2 AS UNSIGNED) day)
FROM Tested 
INNER JOIN Positive  ON Positive.SSN = Tested.SSN
order by rand()
limit 15;

