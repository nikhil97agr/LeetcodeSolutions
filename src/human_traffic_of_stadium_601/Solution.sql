select s1.id, s1.visit_date, s1.people
from stadium s1, stadium s2, stadium s3
where s1.id +1 =s2.id and s2.id + 1 = s3.id
and s1.people >=100 and s2.people >=100 and s3.people >= 100

union 

select s2.id, s2.visit_date, s2.people
from stadium s1, stadium s2, stadium s3
where s1.id +1 =s2.id and s2.id + 1 = s3.id
and s1.people >=100 and s2.people >=100 and s3.people >= 100

union

select s3.id, s3.visit_date, s3.people
from stadium s1, stadium s2, stadium s3
where s1.id +1 =s2.id and s2.id + 1 = s3.id
and s1.people >=100 and s2.people >=100 and s3.people >= 100

order by visit_date asc