select * from 
(
    select
t1.team_name,
1 as half_number,
sum(if(t1.team_name = t2.team_name, 1, -1)) as dominance
from passes p
join teams t1
on p.pass_from = t1.player_id
join teams t2
on p.pass_to = t2.player_id
where time_stamp <= '45:00'
group by t1.team_name

union all

select
t1.team_name,
2 as half_number,
sum(if(t1.team_name = t2.team_name, 1, -1)) as dominance
from passes p
join teams t1
on p.pass_from = t1.player_id
join teams t2
on p.pass_to = t2.player_id
where time_stamp > '45:00'
group by t1.team_name

) data
order by team_name, half_number
