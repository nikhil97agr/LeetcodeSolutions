select distinct(l2.num) as ConsecutiveNums
from logs l1, logs l2, logs l3
where l1.num = l2.num 
and l2.num = l3.num
and l1.id = (select max(id) from logs where id < l2.id)
and l3.id = (select min(id) from logs where id > l2.id)