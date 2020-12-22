use CovidDB;
insert into Positive (SSN)
select Tested.SSN
from Tested
order by RAND()
limit 50;
insert into Healed (SSN)
select Tested.SSN
from Tested
order by RAND()
limit 26;
insert into Death(SSN)
select Tested.SSN
from Tested
order by RAND()
limit 7;
insert into Meth(SSN)
select Tested.SSN
from Tested
order by RAND()
limit 15;

