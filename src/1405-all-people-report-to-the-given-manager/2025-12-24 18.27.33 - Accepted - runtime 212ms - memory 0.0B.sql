with recursive cte as (
    select
    employee_id,
    1 as level
    from employees
    where manager_id = 1 and employee_id != 1

    union all

    select
    e.employee_id,
    level + 1
    from employees e
    join cte c
    on c.employee_id = e.manager_id
    where level < 4
)

select employee_id
from cte