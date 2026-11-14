with data as (select user_id, max(event_date) as latest_date, max(monthly_amount) as max_historical_amount,
datediff(max(event_date), min(event_date)) as days_as_subscriber, sum(if(event_type='downgrade', 1, 0)) as downgrade
from subscription_events
group by user_id
having days_as_subscriber >= 60 and downgrade >= 1)


select d.user_id, plan_name as current_plan, monthly_amount as current_monthly_amount, max_historical_amount, days_as_subscriber
from data d
left join 
subscription_events e
on d.user_id = e.user_id and d.latest_date = e.event_date
where e.event_type <> 'cancel' and monthly_amount < (50*max_historical_amount)/100
order by days_as_subscriber desc
