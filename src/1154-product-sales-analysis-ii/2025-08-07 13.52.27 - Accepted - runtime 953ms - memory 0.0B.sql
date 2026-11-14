select p.product_id, sum(s.quantity) as total_quantity
from product p
join sales s
on s.product_id = p.product_id
group by s.product_id