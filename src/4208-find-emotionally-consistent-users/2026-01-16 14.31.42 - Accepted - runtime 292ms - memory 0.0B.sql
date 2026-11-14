with data as (
    select user_id, count(*) as reaction_count
from reactions
group by user_id
having count(distinct content_id) >= 5
),
data2 as (
    select user_id, reaction, count(*) as reactions
from reactions
group by user_id, reaction
)

select 
d1.user_id,
reaction as dominant_reaction,
 round(reactions/reaction_count, 2) as reaction_ratio
from data d1
join data2 d2
on d1.user_id = d2.user_id
where reactions/reaction_count >= 0.60
order by reaction_ratio desc, d1.user_id