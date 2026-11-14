with points as (
    select 
team_name,
3*wins + draws as points
from teamstats
),
ranking as (
    select
team_name,
count(*) over() as ranks,
rank() over(order by points desc) as position
from points
)

select
p.team_name,
points,
position,
case 
when r.position < (r.ranks/3 + 1)  then 'Tier 1'
when r.position < (2*r.ranks/3 + 1) then 'Tier 2'
else 'Tier 3'
end as tier
from points p
join ranking r
on p.team_name = r.team_name
order by 2 desc, 1 asc