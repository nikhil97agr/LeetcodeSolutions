with data as (

    select employee_id, sum(duration_hours) as duration
    from meetings
    group by employee_id, weekofyear(meeting_date), year(meeting_date)
)

select d.employee_id, e.employee_name, e.department, count(d.employee_id) as meeting_heavy_weeks
from data d
inner join employees e
on d.employee_id = e.employee_id

where d.duration > 20
group by d.employee_id
having count(d.employee_id) >1
order by meeting_heavy_weeks desc, e.employee_name asc