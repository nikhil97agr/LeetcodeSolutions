with mapped as (
    select
    task_id, employee_id,
    start_time as times,
    1 as flag
    from tasks
    union all
    select 
    task_id, employee_id,
    end_time as times,
    -1 as flag
    from tasks
),
concur as (

select
task_id,
employee_id,
times,
sum(flag) over(partition by employee_id order by times asc, flag asc) as res
from mapped
),
concurrent as (
    select employee_id, max(res) as max_concurrent_tasks
from concur
group by employee_id
),
prevEnds as (
    select employee_id, start_time, end_time,
max(end_time) over(partition by employee_id order by start_time rows between unbounded preceding and 1 preceding) as prev_end
from tasks
),
total_hours as (
    select
employee_id,

    floor((sum(timestampdiff(second, start_time, end_time)) - 
sum(
    case when start_time < prev_end and end_time >= prev_end
    then timestampdiff(second, start_time, prev_end)
    when start_time < prev_end and end_time <= prev_end
    then timestampdiff(second, start_time, end_time)
    else 0
    end
))/3600)
 as total_task_hours
from prevEnds
group by employee_id
)

select 
t1.employee_id,
t1.total_task_hours,
c.max_concurrent_tasks
from total_hours t1
join concurrent c
on t1.employee_id = c.employee_id
