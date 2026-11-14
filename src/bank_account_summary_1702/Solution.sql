with cte as (
    select
user_id,
sum(credit) as credit
from
(
    select
paid_by as user_id,
sum(-amount) as credit
from transactions
group by paid_by
union all
select
paid_to as user_id,
sum(amount) as credit
from transactions
group by paid_to
) a
group by user_id

)

select
u.user_id,
u.user_name,
u.credit + ifnull(c.credit, 0) as credit,
if(u.credit + ifnull(c.credit, 0) < 0, 'Yes', 'No') as credit_limit_breached
from 
users u
left join cte c
on u.user_id = c.user_id
