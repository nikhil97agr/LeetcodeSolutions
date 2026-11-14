with cte as (
    select
product_id,
year(purchase_date) as year,
count(order_id) as cnt
from orders
group by product_id, year(purchase_date)
order by product_id, year asc
)


select
distinct c1.product_id
from cte c1
join cte c2
on c1.product_id = c2.product_id
and c1.year + 1 = c2.year
where c1.cnt >= 3 and c2.cnt >= 3