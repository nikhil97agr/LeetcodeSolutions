with cte1 as (select
user_id1 as f1, user_id2 as f2
from friends

union all

select user_id2 as f1, user_id1 as f2
from friends ),
cte2 as (

select 
distinct f.user_id1,
f.user_id2
from friends f
join cte1 c1
on c1.f1 = f.user_id1 and c1.f2 <> f.user_id2
join cte1 c2
on c2.f1 = f.user_id2 and c2.f2 <> f.user_id1
where c1.f2 = c2.f2
)

select 
f.user_id1,
f.user_id2
from friends f
left join cte2 c
on f.user_id1 = c.user_id1 and f.user_id2 = c.user_id2
where c.user_id1 is null
order by f.user_id1 asc, f.user_id2 asc