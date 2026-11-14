select e1.id, e1.month, sum(e2.salary) as salary
from employee e1
join employee e2
on e1.id = e2.id
and (e1.month = e2.month or e1.month -1 = e2.month or e1.month -2 = e2.month)
where (e1.id, e1.month) not in (select id, max(month) as month from employee group by id)
group by e1.id, e1.month
order by e1.id asc, e1.month desc