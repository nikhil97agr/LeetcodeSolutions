with platforms as (
    select 'mobile' as platform
    union 
    select 'desktop' as platform
    union 
    select 'both' as platform
    ),
    
    
    dates as (
    select distinct spend_date,
    platforms.platform
    from spending, platforms
),
data as (
    select
user_id,
spend_date,
if(count(distinct platform) > 1, 'both', platform) as platform,
sum(amount) as amt
from spending
group by spend_date, user_id
)


select
d1.spend_date,
d1.platform,
ifnull(sum(amt), 0) as total_amount,
count(distinct user_id) as total_users
from dates d1
left join data d2
on d1.spend_date = d2.spend_date and d1.platform = d2.platform
group by d1.spend_date, platform

