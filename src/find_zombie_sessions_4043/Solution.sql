with cte as (
    select
session_id,
user_id,
timestampdiff(minute, min(event_timestamp), max(event_timestamp)) as session_duration_minutes,
sum(if(event_type='scroll', 1, 0)) as scroll_count,
sum(if(event_type='click', 1, 0)) as click_count,
sum(if(event_type = 'purchase', 1, 0)) as purchase_count
from app_events
group by session_id
having scroll_count >=5 and purchase_count=0 and (scroll_count <> 0 and click_count/scroll_count < 0.2) and session_duration_minutes > 30
)

select 
session_id,
user_id,
session_duration_minutes,
scroll_count
from cte
order by scroll_count desc, session_id