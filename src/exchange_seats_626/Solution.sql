select s1.id, s2.student
from seat s1
left join seat s2
on s1.id = s2.id -1
where s1.id%2 = 1 and s2.id is not null

union

select s2.id, s1.student
from seat s1
left join seat s2
on s1.id = s2.id - 1
where s2.id %2 =0 and s1.id is not null

union 

select s1.id, s1.student
from seat s1
left join seat s2
on s1.id = s2.id -1
where s1.id%2 = 1 and s2.id is  null

order by id