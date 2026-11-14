with cte as (
    select product_id, order_date, order_id, rank() over(partition by product_id order by order_date desc) as ranks
    from orders
)

select
product_name,
p.product_id,
order_id,
order_date
from cte
left join products p
on p.product_id = cte.product_id
where cte.ranks = 1
order by product_name asc, p.product_id asc, cte.order_id asc