with data as (
    select  i.item_category, dayofweek(order_date) as week_day, sum(quantity) as qty
    from items i
    left join orders o
    on i.item_id = o.item_id
    group by i.item_category, week_day
    order by i.item_category

)

select item_category as Category,
sum(if(week_day = 2, qty, 0)) as 'Monday',
sum(if(week_day = 3, qty, 0)) as 'Tuesday',
sum(if(week_day = 4, qty, 0)) as 'Wednesday',
sum(if(week_day = 5, qty, 0)) as 'Thursday',
sum(if(week_day = 6, qty, 0)) as 'Friday',
sum(if(week_day = 7, qty, 0)) as 'Saturday',
sum(if(week_day = 1, qty, 0)) as 'Sunday'
from data
group by Category
order by Category
