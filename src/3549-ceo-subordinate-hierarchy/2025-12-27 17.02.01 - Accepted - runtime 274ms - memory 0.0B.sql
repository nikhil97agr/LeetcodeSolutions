with recursive cte as (
    select employee_id, employee_name, salary as salary_difference, salary, manager_id, 0 as hierarchy_level
    from employees
    where manager_id is null

    union all 

    select
    e.employee_id,
    e.employee_name,
    e.salary - cte.salary as salary_difference,
    cte.salary,
    e.manager_id,
    hierarchy_level + 1
    from cte
    join employees e
    on cte.employee_id = e.manager_id


)

select
employee_id as subordinate_id,
employee_name as subordinate_name,
hierarchy_level,
salary_difference
from cte
where manager_id is not null
order by hierarchy_level asc, employee_id asc