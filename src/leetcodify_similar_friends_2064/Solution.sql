with cte as (
    select
user_id,
song_id,
day
from listens
group by user_id,
song_id,
day
)

select 
distinct f.user1_id,
f.user2_id
from friendship f
join cte c1
join cte c2
on f.user1_id = c1.user_id and f.user2_id = c2.user_id and c1.song_id = c2.song_id and c1.day = c2.day
group by f.user1_id, f.user2_id, c1.day
having count(distinct c1.song_id) >= 3