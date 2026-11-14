with project_req as (
    select
    project_id, count(skill) as req
    from projects
    group by project_id
),
candidate as (
    select
candidate_id,
p.project_id,
count(p.skill) as skills,
sum(
    if(proficiency > importance,
    10, if(proficiency < importance, -5, 0))
) + 100 as score
from candidates c
join projects p
on c.skill = p.skill
group by c.candidate_id, p.project_id
),
data as (
    select
candidate_id,
c.project_id,
score
from candidate c
join project_req p
on c.project_id = p.project_id
where c.skills = p.req

)

select
project_id,
candidate_id,
score
from (
    select
project_id,
candidate_id,
score,
rank() over(partition by project_id order by score desc, candidate_id) as ranks
from data
) d
where ranks = 1
order by project_id



