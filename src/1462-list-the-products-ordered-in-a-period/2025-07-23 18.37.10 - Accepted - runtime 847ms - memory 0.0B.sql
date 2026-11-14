select p.product_name, sum(o.unit) as unit
from products p, orders o
where p.product_id = o.product_id
and extract(month from order_date) = 2
and extract(year from order_date) = 2020
group by p.product_id
having sum(o.unit)>=100;