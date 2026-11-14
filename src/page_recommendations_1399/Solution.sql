with cte as (
    select distinct user2_id as user_id
    from friendship
    where user1_id = 1
    union
    select distinct user1_id as user_id
    from friendship
    where user2_id = 1
)


select 
distinct l.page_id as recommended_page
from cte c
join likes l
on l.user_id = c.user_id
where l.page_id not in (select page_id from likes where user_id = 1)
