with ordered as (
    select *, lag(session_date) over(partition by student_id order by session_id) as prev_date
    from study_sessions
),
marked as (
    select *, case when prev_date is null then 0 when datediff(session_date, prev_date) <= 2 then 0 else 1 end as is_break
    from ordered
),
segmented as (
    select *, sum(is_break) over (partition by student_id order by session_date) as segment_id
    from marked
),
data as (
    select student_id, segment_id, count(*) as session_cnt, count(distinct subject) as cycle_length, sum(hours_studied) as total_study_hours
    from segmented
    group by student_id, segment_id
    having cycle_length >= 3 and session_cnt >= 2 * cycle_length
)

select s.student_id, student_name, major, cycle_length, total_study_hours
from students as s
join data as m
on s.student_id = m.student_id
order by cycle_length desc, total_study_hours desc