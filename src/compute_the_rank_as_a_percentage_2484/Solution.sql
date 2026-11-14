with cte as (
    select
student_id,
department_id,
rank() over(partition by department_id order by mark desc) as ranks
from students
),
cte2 as (
    select
    department_id,
    count(distinct student_id) as cnt
    from students
    group by department_id
)

select
c1.student_id,
c2.department_id,
ifnull(round((ranks - 1)*100/(cnt - 1)   , 2), 0) as percentage
from cte c1
join cte2 c2
on c1.department_id = c2.department_id