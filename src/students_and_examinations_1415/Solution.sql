select s.student_id, s.student_name, s.subject_name, sum(if(e.subject_name is null, 0, 1)) as attended_exams
from (select student_id, student_name, subject_name
from students, subjects) s
left join examinations e
on s.student_id = e.student_id and e.subject_name = s.subject_name

group by s.student_id, s.subject_name
order by s.student_id, s.subject_name