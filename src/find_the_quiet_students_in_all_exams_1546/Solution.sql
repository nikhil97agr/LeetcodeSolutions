with filter as (select distinct(student_id) as id
from (select student_id, score, rank() over(partition by exam_id order by score desc) 'highest', rank() over(partition by exam_id order by score asc) 'lowest'
from exam) s
where highest = 1 or lowest=1),

st as (
    select s.student_id, s.student_name
    from exam e
    join student s
    on s.student_id = e.student_id
    group by s.student_id
)

select st.student_id, st.student_name
from st 
left join filter f
on st.student_id = f.id
where f.id is null
order by student_id