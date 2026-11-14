select manager_name, dep_id
from (select e1.emp_name as manager_name, e1.dep_id, count(*) as cnt, rank() over(order by count(*) desc) as ranked
from employees e1
join employees e2
on e1.dep_id = e2.dep_id
where e1.position = 'Manager'
group by e1.emp_name, e1.dep_id
order by e1.dep_id) data
where ranked = 1