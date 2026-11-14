with data as (
    select
host_team as team,
sum(
    if(
        host_goals > guest_goals,
        3,
        if(host_goals = guest_goals, 1 , 0)
    )
) as points
from matches
group by host_team

union all

    select
guest_team as team,
sum(
    if(
        host_goals > guest_goals,
        0,
        if(host_goals = guest_goals, 1 , 3)
    )
) as points
from matches
group by guest_team
)

select
t.team_id,
t.team_name,
ifnull(sum(d.points), 0) as num_points
from data d
right join teams t
on t.team_id = d.team
group by t.team_id
order by num_points desc, t.team_id asc