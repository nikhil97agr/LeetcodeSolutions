with ranked as (
    select
    team_id,
    name,
    rank() over(order by points desc, name asc) as ranks
    from teampoints
),
total_change as (
    select 
    team_id,
    sum(points_change) as changed
    from pointschange
    group by team_id
),
updated_rank as (
    select
    t.team_id,
    rank() over(order by t.points + c.changed desc, t.name asc)  as ranks
    from teampoints t
    left join total_change c
    on t.team_id = c.team_id
    
)

select
r.team_id,
r.name,
(cast(r.ranks as signed) - cast(u.ranks as signed)) as rank_diff
from ranked r
join updated_rank u
on r.team_id = u.team_id