with cte as (
    select
    invoice_id,
    sum(price*quantity) as total
    from products p
    join purchases p1
    on p.product_id = p1.product_id
    group by invoice_id
    order by total  desc, invoice_id  asc
    limit 1
)

select 
p1.product_id,
p.quantity,
p.quantity*p1.price  as price
from purchases p
join cte c
on p.invoice_id = c.invoice_id
join products p1
on p.product_id = p1.product_id