select round(count(a.player_id)/count(p.player_id),2) as fraction
from (select player_id, min(event_date) as first_day
from activity
group by player_id) p
left join activity a
on p.player_id = a.player_id
and event_date = date_add(first_day, interval 1 day)
