select p.product_id, p.product_name
from product p
left join sales s
on p.product_id = s.product_id
group by p.product_id
having extract(month from max(s.sale_date)) between 1 and 3 and extract(year from max(sale_date)) = 2019 and extract(year from min(sale_date)) = 2019