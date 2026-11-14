with ranked_data as (
    select user_id, created_at, row_number() over(partition by user_id order by created_at asc) as row_num
    from users
)

select
distinct r1.user_id
from ranked_data r1
join ranked_data r2
on r1.user_id = r2.user_id and r2.row_num = r1.row_num + 1
where datediff(r2.created_at, r1.created_at) <= 7