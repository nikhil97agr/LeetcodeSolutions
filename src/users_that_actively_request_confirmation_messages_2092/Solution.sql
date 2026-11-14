with cte as (
    select
    user_id,
    time_stamp,
    rank() over( partition by user_id order by time_stamp asc) as ranks
    from confirmations

)

select
distinct c1.user_id as user_id
from cte c1
join cte c2
on c1.ranks = c2.ranks - 1 and c1.user_id = c2.user_id
where timestampdiff(second, c1.time_stamp, c2.time_stamp)<=24*60*60