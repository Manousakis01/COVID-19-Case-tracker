use CovidDB;

drop view dates;

create view dates as (
select dateOfTest, Tested.SSN as SSN
 from Positive, Tested 
 where Positive.SSN=Tested.SSN 
 );
 
insert into Positive 
select Tested.SSN
from Tested
order by  dateOfTest desc
limit  354;

INSERT INTO Healed (SSN, dateOfHealed)
SELECT Positive.SSN, DATE_ADD(dates.dateOfTest, Interval + CAST(RAND() * (3)+10 AS UNSIGNED) day)
FROM dates
INNER JOIN Positive  ON Positive.SSN = dates.SSN
order by rand()
limit 132;

INSERT INTO Meth (SSN, dateOfMeth)
SELECT Positive.SSN, DATE_ADD(dates.dateOfTest, Interval + CAST(RAND() * (3)+2 AS UNSIGNED) day)
FROM dates
INNER JOIN Positive  ON Positive.SSN = dates.SSN
order by rand()
limit 75;

INSERT INTO Death (SSN, dateOfDeath)
SELECT Meth.SSN, DATE_ADD(Tested.dateOfTest, Interval + CAST(RAND() * (4)+9 AS UNSIGNED) day)
FROM Tested 
INNER JOIN Meth  ON Meth.SSN = Tested.SSN
order by rand()
limit 39;

