with grouped_order as (
    select customer_id,
    sum(case when month(order_date) = 6 then price*quantity else 0 end) as june, 
    sum(case when month(order_date) = 7 then price*quantity else 0 end) as july 
    from orders o
    join product p
    on o.product_id = p.product_id
    where (month(order_date) between 6 and 7) and year(order_date) = 2020
    group by customer_id
)

select c.customer_id, name
from grouped_order o
join customers c
on c.customer_id = o.customer_id
where june >= 100 and july >= 100;