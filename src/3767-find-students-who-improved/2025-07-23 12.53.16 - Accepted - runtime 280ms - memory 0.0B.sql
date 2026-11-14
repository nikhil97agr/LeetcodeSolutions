with ranks as 
(
    select student_id, subject, score, 
row_number() over(partition by student_id, subject order by exam_date asc) as start_row,
row_number() over(partition by student_id, subject order by exam_date desc) as end_row
from scores
)

select s1.student_id, s1.subject, s1.score as first_score, s2.score as latest_score
from ranks s1
left join ranks s2
on s1.student_id = s2.student_id
and s1.subject = s2.subject
where s1.start_row = 1
and s2.end_row = 1
and s2.score > s1.score

order by s1.student_id, s1.subject