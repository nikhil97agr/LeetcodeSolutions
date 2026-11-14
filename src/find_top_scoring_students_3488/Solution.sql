with course as (
    select
major,
count(*) as courses
from courses
group by major
),
data as (
    select
s.student_id,
s.major,
count(c.course_id) as attended,
sum(if(grade = 'A', 1, 0)) as grade
from courses c
join enrollments e
join students s
on e.course_id = c.course_id and s.student_id = e.student_id
where s.major = c.major
group by student_id
)

select
student_id
from data d
join course c
on d.major =c.major
where d.attended = c.courses
and d.grade = c.courses
order by student_id asc