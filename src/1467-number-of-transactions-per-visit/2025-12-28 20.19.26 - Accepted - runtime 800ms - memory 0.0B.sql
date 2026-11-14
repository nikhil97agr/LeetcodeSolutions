with recursive cte as (
    select
v.user_id,
v.visit_date,
count(t.transaction_date) as cnt
from visits v
left join transactions t
on v.user_id = t.user_id and v.visit_date = t.transaction_date
group by v.user_id, v.visit_date
),
 t2 as (
    select 0 as id 
    union all
    select
    id + 1
    from t2
    where id +1 <= (select max(cnt) from cte)
)


select 
id as transactions_count,
count(user_id) as visits_count
from t2
left join cte
on id = cnt
group by id
order by id asc
