with friends as (
    select
user1_id,
user2_id
from friendship
union 
select 
user2_id as user1_id,
user1_id as user2_id
from friendship
),
friend_like as (
    select
user1_id as user_id,
page_id,
count(user_id) as friends_likes
from friends f
join likes l
on f.user2_id = l.user_id
group by f.user1_id, page_id
)

select 
f.user_id,
f.page_id,
friends_likes
from friend_like f
left join likes l
on f.user_id = l.user_id and l.page_id = f.page_id
where l.user_id is null