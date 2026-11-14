select data.customer_id, data.product_id, p.product_name
from 
(select c.customer_id, o.product_id, count(*) as cnt, rank() over(partition by customer_id order by count(*) desc) as ranks
from customers c
join orders o
on c.customer_id = o.customer_id
group by c.customer_id, o.product_id) data
join products p
on p.product_id = data.product_id
where ranks = 1

