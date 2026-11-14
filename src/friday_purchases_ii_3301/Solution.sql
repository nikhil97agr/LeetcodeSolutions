with recursive cte as (
    select 1 as week_of_month, '2023-11-03' as week_date
    union all 
    select week_of_month + 1, date_add(week_date, interval 7 day)
    from cte
    where week_of_month < 4
),
cte2 as (
    select
purchase_date,
week(purchase_date) - week('2023-11-01') + 1 as weeks,
sum(amount_spend) as total
from purchases
where weekday(purchase_date) = 4
group by weeks
)

select
week_of_month,
week_date as purchase_date,
ifnull(total, 0) as total_amount
from cte c1
left join cte2 c2
on c1.week_of_month = c2.weeks
group by week_of_month
