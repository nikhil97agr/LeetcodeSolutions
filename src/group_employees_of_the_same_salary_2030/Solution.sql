with cte as (
    select 
    salary
    from employees
    group by salary
    having count(*) > 1
),
emp as (
    select 
    employee_id, name, c.salary
    from cte c 
    left join employees e
    on c.salary = e.salary
)

select
employee_id,
name,
salary,
dense_rank() over(order by salary asc) as team_id
from emp
order by team_id asc, employee_id asc