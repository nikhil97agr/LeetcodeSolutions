with cte as (
    select player_id, sum(score) as score
from (select 
first_player as player_id, 
sum(first_score) as score
from matches group by first_player
union all
select second_player as player_id,
sum(second_score) as score
from matches group by second_player) matche
group by player_id
),
cte_2 as (
    select group_id, p.player_id, row_number() over(partition by group_id order by ifnull(score, 0) desc, player_id asc) as ranks
from players p
left join
cte c
on p.player_id = c.player_id
)


select group_id, player_id
from cte_2
where ranks = 1


