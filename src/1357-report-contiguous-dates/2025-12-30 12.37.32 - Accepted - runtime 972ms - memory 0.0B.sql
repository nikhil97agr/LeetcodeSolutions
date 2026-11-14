with d1 as (
    select
fail_date as dates,
'failed' as status,
rank() over(order by fail_date) as rank1
from failed
where year(fail_date) = 2019

union all
select success_date as dates,
'succeeded' as status,
rank() over(order by success_date) as rank1
from succeeded
where year(success_date) = 2019
),
d2 as (
    select 
dates,
status,
rank() over(order by dates) as rank2, rank1
from d1
)


select
status as period_state,
min(dates) as start_date,
max(dates) as end_date
from d2
group by status, rank2 - rank1
order by start_date

