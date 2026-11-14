select customer_id, customer_name
from (
    select c.customer_id, c.customer_name, sum(if(product_name='A', 1, 0)) as a,
sum(if(product_name='B', 1, 0)) as b,
sum(if(product_name='C', 1, 0)) as c
from customers c
left join orders o
on c.customer_id = o.customer_id
group by c.customer_id
) data
where a > 0 and b > 0 and c =0
order by customer_id asc