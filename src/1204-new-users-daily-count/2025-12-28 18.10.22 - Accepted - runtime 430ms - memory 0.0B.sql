with t1 as (
    select 
    user_id,
    min(activity_date) as login 
    from traffic
    where activity = 'login'
    group by user_id
    having datediff('2019-06-30', login) <= 90
)

select 
login  as login_date,
count(*) as user_count
from t1
group by login_date