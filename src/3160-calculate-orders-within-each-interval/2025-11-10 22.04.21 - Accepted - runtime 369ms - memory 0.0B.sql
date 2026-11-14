select floor(((minute-1)/6))+1 as interval_no, sum(order_count) as total_orders
from orders
group by interval_no
order by interval_no