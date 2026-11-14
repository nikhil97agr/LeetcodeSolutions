with cte as (
    select
player_id,
result,
match_day,
rank() over(partition by player_id order by match_day asc) as player_seq,
rank() over(partition by player_id, result order by match_day asc) as result_seq
from matches
),
cte2 as (
    select
    player_id,
    max(streak) as longest_streak
    from (
        select
c1.player_id,
count(c2.match_day) as streak
from cte c1
left join cte c2
on c1.player_id = c2.player_id and c1.result = 'Win' and c2.result = c1.result
where c1.result_seq <= c2.result_seq
and c2.player_seq - c1.player_seq = c2.result_seq - c1.result_seq
group by c1.player_id, c1.match_day
    ) c
    group by player_id
),
cte3 as (
    select distinct player_id from matches
)

select 
c1.player_id,
ifnull(c2.longest_streak, 0) as longest_streak
from cte3 c1
left join cte2 c2
on c1.player_id = c2.player_id