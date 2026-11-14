select id as employee_id
from (select distinct(employee_id) as id
from employees 
union
select distinct(employee_id) as id
from salaries
) ids
where ids.id not in ( select distinct(employee_id) from employees)
or ids.id not in (select distinct(employee_id) from salaries)
order by employee_id asc