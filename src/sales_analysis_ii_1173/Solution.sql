with s8 as (
    select distinct(buyer_id) as buyer_id
    from product p
    join sales s
    on p.product_id = s.product_id
    where product_name = 'S8'
)

select s.buyer_id
from s8 s
left join sales s1
on s.buyer_id = s1.buyer_id
left join product p 
on p.product_id = s1.product_id
and product_name = 'iPhone'
group by s.buyer_id
having count(p.product_id) = 0
