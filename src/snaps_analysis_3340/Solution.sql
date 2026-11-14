select
b.age_bucket,
round((sum(if(activity_type = 'send', time_spent, 0))/sum(time_spent))*100, 2)  as send_perc,
round((sum(if(activity_type = 'open', time_spent, 0))/sum(time_spent))*100, 2) as open_perc
from activities a
join age b
on a.user_id = b.user_id
group by b.age_bucket