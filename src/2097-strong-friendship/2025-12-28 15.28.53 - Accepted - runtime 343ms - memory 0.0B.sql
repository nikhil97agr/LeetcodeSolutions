with list as (
    select 
    user1_id as f1,
    user2_id as f2
    from friendship
    union all
    select 
    user2_id as f1,
    user1_id as f2
    from friendship
)

select 
f.user1_id,
f.user2_id,
count(l1.f2) as common_friend
from friendship f
join list l1
on f.user1_id = l1.f1 and f.user2_id != l1.f2
join list l2
on f.user2_id = l2.f1 and f.user1_id != l2.f2
where l1.f2 = l2.f2
group by f.user1_id, f.user2_id
having common_friend >= 3