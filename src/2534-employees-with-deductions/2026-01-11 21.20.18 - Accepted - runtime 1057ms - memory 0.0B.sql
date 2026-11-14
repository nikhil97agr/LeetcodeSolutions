with data as (
    select
employee_id,
ceil(sum(timestampdiff(second, in_time, out_time))/60) as minutes
from logs
group by employee_id
)

select 
e.employee_id
from employees e
left join data d
on e.employee_id = d.employee_id
where d.employee_id is null or d.minutes < needed_hours*60