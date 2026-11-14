select concat(year(order_date), '-', if(month(order_date) <= 9, concat('0', month(order_date)), month(order_date))) as month , count(invoice) as order_count, count(distinct(customer_id)) as customer_count
from orders
where invoice > 20
group by year(order_date), month(order_date)
