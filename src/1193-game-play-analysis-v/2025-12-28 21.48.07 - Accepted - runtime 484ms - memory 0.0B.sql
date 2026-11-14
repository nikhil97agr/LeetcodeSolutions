with cte as (
    select
player_id,
min(event_date) as install_dt
from activity
group by player_id

),
t1 as (
    select
c.install_dt,
count(event_date) as events
from cte c
left join activity a
on c.player_id = a.player_id
and datediff(a.event_date, c.install_dt) =1 
group by c.install_dt
),
t2 as (
    select
install_dt,
count(*) as installs 
from cte
group by install_dt
)

select
t1.install_dt,
installs,
round(events/installs, 2) as Day1_retention
from t2
join t1
on t2.install_dt = t1.install_dt