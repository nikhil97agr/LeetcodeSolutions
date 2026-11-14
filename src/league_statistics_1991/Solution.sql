with cte as (
    select
home_team_id as team_id,
sum(if(
    home_team_goals > away_team_goals, 3,
    if(
        home_team_goals = away_team_goals,
        1,
        0
    )
)) as points,
count(*) as matches_played,
sum(home_team_goals) as goal_for,
sum(away_team_goals) as goal_against
from matches
group by home_team_id

union all

select 
away_team_id as team_id,
sum(if(
    home_team_goals > away_team_goals, 0,
    if(
        home_team_goals = away_team_goals,
        1,
        3
    )
)) as points,
count(*) as matches_played,
sum(away_team_goals) as goal_for,
sum(home_team_goals) as goal_against
from matches
group by away_team_id
),
cte2 as (
    select 
t.team_name,
sum(matches_played) as matches_played,
sum(c.points) as points,
sum(c.goal_for) as goal_for,
sum(c.goal_against) as goal_against
from teams t
join cte c
on t.team_id = c.team_id
group by t.team_id
)


select *, 
goal_for - goal_against as goal_diff
from cte2
order by points desc, goal_diff desc, team_name asc