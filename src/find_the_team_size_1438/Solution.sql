select e1.employee_id, count(*) as team_size
from employee e1
join employee e2 
on e1.team_id = e2.team_id
group by e1.employee_id