select
s1.user_id,
s1.steps_date,
round(avg(s2.steps_count), 2) as rolling_average
from steps s1
left join steps s2
on s1.user_id = s2.user_id
and datediff(s1.steps_date, s2.steps_date) between 0 and 2
group by s1.user_id, s1.steps_date
having count(distinct(s2.steps_date)) = 3