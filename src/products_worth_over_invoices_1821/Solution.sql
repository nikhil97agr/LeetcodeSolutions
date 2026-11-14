select
name,
ifnull(sum(rest), 0) as rest,
ifnull(sum(paid), 0) as paid,
ifnull(sum(canceled), 0) as canceled,
ifnull(sum(refunded), 0) as refunded
from product p
left join invoice i
on i.product_id = p.product_id
group by p.product_id
order by name asc