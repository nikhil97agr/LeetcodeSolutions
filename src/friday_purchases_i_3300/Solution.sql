with cte as (
    select user_id,
    purchase_date,
    amount_spend as amount,
    dayofweek(purchase_date) as weekDay,
    week(purchase_date) - week('2023-11-01')+1 as week
    from purchases
)


select week as week_of_month,
purchase_date,
sum(amount) as total_amount
from cte
where weekDay = 6 
group by purchase_date
having total_amount <> 0
order by week_of_month asc