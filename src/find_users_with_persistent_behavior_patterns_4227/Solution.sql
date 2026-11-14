with cte as (
    select user_id,
action,
count(*) as streak_length,
min(action_date) as start_date,
max(action_date) as end_date
from activity
group by user_id, action
)

select * 
from cte
where streak_length >= 5
order by streak_length desc, user_id asc