with cte as (
    select 
    distinct f1,
    f2
    from (
        select
user1 as f1,
user2 as f2
from friends
union all
select 
user2 as f1,
user1 as f2
from friends
    )data
),
t2 as (
    select 
f1,
count(f2) as f2
from cte
group by f1
)


select
f1 as user1,
round((f2 * 100)/(select count(*) from t2), 2) as percentage_popularity
from t2
order by user1 asc
