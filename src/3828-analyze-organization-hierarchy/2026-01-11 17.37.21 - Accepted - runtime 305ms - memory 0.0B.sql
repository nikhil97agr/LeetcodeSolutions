with recursive cte as (
    select employee_id, employee_name,  1 as level
    from employees
    where manager_id is null

    union all

    select 
    e.employee_id,
    e.employee_name,
    level + 1
    from cte c
    join employees e
    on c.employee_id = e.manager_id
),
cte2 as (
    select employee_id as manager,
    employee_id as sub,
    salary
    from employees
    union
    select
    c.manager,
    e.employee_id as sub,
    e.salary
    from employees e
    join cte2 c
    on e.manager_id = c.sub
),
data as (
    select
manager as employee_id,
sum(salary) as budget,
count(*) -1 as team_size
from cte2 
group by manager
)

select
e.employee_id,
e.employee_name,
c.level,
team_size,
budget
from employees e
join data d
join cte c
on e.employee_id= c.employee_id and e.employee_id = d.employee_id
order by level, budget desc, employee_name
