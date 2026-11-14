with ratings as (
    select
customer_id,
count(order_id) as total_orders,
round(avg(order_rating), 2) as average_rating,
sum(if(
time(order_timestamp) between "11:00:00" and "14:00:00" or time(order_timestamp) between "18:00:00" and "21:00:00",
1,
0
)) as peak_orders
from restaurant_orders
group by customer_id
having total_orders >= 3 and average_rating >= 4
and sum(if(order_rating is null, 0, 1))/total_orders >= 0.5 
and peak_orders / total_orders >= 0.6
)



select
customer_id,
total_orders,
round(peak_orders*100/total_orders, 0) as peak_hour_percentage,
average_rating
from ratings
order by average_rating desc, customer_id desc