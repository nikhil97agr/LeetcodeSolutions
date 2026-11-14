with top as (
    select
user_id
from course_completions
group by user_id
having count(*) >= 5 and avg(course_rating) >= 4
),
courses as (
    select 
t1.user_id,
course_name,
completion_date,
rank() over(partition by user_id order by completion_date) as rnk
from top t1
join course_completions c
on t1.user_id = c.user_id

)

select
c1.course_name as first_course,
c2.course_name as second_course,
count(*) as transition_count
from courses c1
join courses c2
on c1.user_id = c2.user_id and c2.rnk > c1.rnk
and c2.rnk - c1.rnk = 1
group by c1.course_name, c2.course_name
order by transition_count desc, first_course, second_course