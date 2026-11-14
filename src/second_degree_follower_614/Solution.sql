with c1 as (
    select followee as follower, count(*) as num
    from follow
    group by followee
),
c2 as (
    select distinct(follower) follower
    from follow
)

select c1.follower, c1.num
from c1
left join c2
on c1.follower = c2.follower
where c2.follower is not null
order by c1.follower asc