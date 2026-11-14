select student_id, course_id, grade
from (
    select student_id, course_id, grade, dense_rank() over(partition by student_id order by grade desc, course_id asc) as ranks 
from enrollments
) d

where ranks = 1;