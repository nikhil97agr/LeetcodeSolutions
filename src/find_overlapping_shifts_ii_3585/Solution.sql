with shifts as (
    select employee_id, date(start_time) as shift_date, start_time as shift_time, 1 as flag
    from employeeshifts
    union all
    select employee_id, date(end_time) as shift_date, end_time as shift_time, -1 as flag
    from employeeshifts
),
overlap_shifts as (
    select
employee_id,
shift_date,
shift_time,
sum(flag) over(partition by employee_id, shift_date order by shift_time) as overlap_count
from shifts
),
overlap_data as (
    select
employee_id,
max(overlap_count) as max_overlapping_shifts
from overlap_shifts
group by employee_id
),
shift_duration as (
    select
e1.employee_id,
sum(
    greatest(
        timestampdiff(
            minute,
            greatest(e1.start_time, e2.start_time),
            least(e1.end_time, e2.end_time)
        ),0
    )
) as total_overlap_duration
from employeeshifts e1 
join employeeshifts e2
on e1.employee_id =e2.employee_id and e1.start_time < e2.start_time
where e1.end_time > e2.start_time
group by e1.employee_id
)

select
distinct e1.employee_id,
ifnull(max_overlapping_shifts, 1) as max_overlapping_shifts,
ifnull(total_overlap_duration, 0) as total_overlap_duration
from 
employeeshifts e1
left join overlap_data o
on e1.employee_id = o.employee_id
left join shift_duration s
on e1.employee_id = s.employee_id
order by e1.employee_id 