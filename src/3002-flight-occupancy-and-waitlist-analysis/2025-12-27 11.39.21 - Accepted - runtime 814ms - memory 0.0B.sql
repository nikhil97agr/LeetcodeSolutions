with cte as (
    select 
    flight_id,
    count(passenger_id) as cnt
    from passengers
    group by flight_id
)

select
f.flight_id,
ifnull(if(cnt is null  or capacity >= cnt, cnt, capacity), 0) as booked_cnt,
ifnull(if(capacity >= cnt, 0, cnt - capacity), 0) as waitlist_cnt
from flights f
left join cte c
on f.flight_id = c.flight_id
order by f.flight_id asc
