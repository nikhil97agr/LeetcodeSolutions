select
school_id,
ifnull(min(score), -1) as score
from schools s
left join exam e
on s.capacity >= e.student_count
group by school_id