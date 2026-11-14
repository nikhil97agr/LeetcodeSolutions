with ordered as (
    select
caller_id,
recipient_id,
date(call_time) as call_date,
call_time
from calls
union all
select
recipient_id as caller_id,
caller_id as recipient_id,
date(call_time) as call_date,
call_time
from calls
),
data as (
    select
caller_id,
recipient_id,
call_date,

rank() over(partition by caller_id, call_date order by call_time) as ranks
from ordered
),
start_end as (
    select caller_id, call_date, min(ranks) as start, max(ranks) as end
from data
group by caller_id, call_date
)

select
distinct d1.caller_id as user_id
from start_end s
join data d1
join data d2
on 
d1.caller_id = s.caller_id
and d1.call_date = s.call_date
and d2.caller_id = s.caller_id
and d2.call_date = s.call_date
where s.start = d1.ranks and s.end = d2.ranks and d1.recipient_id = d2.recipient_id