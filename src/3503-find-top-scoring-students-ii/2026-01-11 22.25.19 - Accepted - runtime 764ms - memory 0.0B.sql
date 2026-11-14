with data as (
    select
s.student_id,
c.major,
grade,
sum(if(mandatory = 'yes', 1, 0)) as mandatory,
sum(if(mandatory = 'yes', 0, 1)) as elective,
sum(if(mandatory = 'yes' and grade = 'A', 1, 0)) as mandate_grade,
sum(if(mandatory = 'no' and (grade ='A' or grade ='B'), 1,0 )) as elective_grade
from
students s
join courses c
join enrollments e
on s.student_id = e.student_id 
and c.course_id = e.course_id
and s.major = c.major
group by s.student_id, c.major

),
gpa as (
    select 
student_id
from enrollments
group by student_id
having avg(gpa) >= 2.5
),
course as (
    select
major,
sum(if(mandatory = 'yes', 1, 0)) as mandatory
from courses
group by major


)

select
d.student_id
from data d
join gpa g
join course c
on d.student_id = g.student_id 
and d.major = c.major
where c.mandatory = d.mandatory 
and c.mandatory = d.mandate_grade
and d.elective >= 2
and d.elective = d.elective_grade
order by d.student_id