with ranked_data as (
    select r1.user_id as user1_id, r2.user_id as user2_id, rank() over( order by count(*) desc) as ranks
from relations r1
join relations r2
on r1.follower_id = r2.follower_id
and r1.user_id < r2.user_id
group by r1.user_id, r2.user_id
)

select user1_id, user2_id
from ranked_data
where ranks = 1
