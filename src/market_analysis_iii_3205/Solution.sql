with cte as (
    select
seller_id,
item_brand,
i.item_id
from orders o
join items i
on i.item_id = o.item_id

),
 data as (
    select 
u.seller_id,
count(distinct c.item_id) as total
from users u
left join cte c
on u.seller_id = c.seller_id
and u.favorite_brand <> item_brand
group by u.seller_id
)


select seller_id,
total as num_items
from data
where total = (select max(total) from data)
order by seller_id asc

