select seller_name
from seller s
left join orders o
on o.seller_id = s.seller_id
and year(sale_date) = 2020
where o.order_id is null
order by seller_name asc
