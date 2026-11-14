with data as (
    select s.user_id, p.product_id, sum(p.price*s.quantity) as total
from sales s
left join product p
on s.product_id = p.product_id
group by s.user_id, s.product_id
)

select data.user_id, product_id
from data, (select user_id, max(total) as total from data group by user_id) d2
where data.user_id = d2.user_id and data.total = d2.total;