with order_fav as (
    select 
    order_date,
    item_brand,
    seller_id,
    rank() over(partition by seller_id order by order_date asc) as ranks
    from orders o
    join items i
    on i.item_id = o.item_id
)

select
u.user_id as seller_id,
if(seller_id is null, 'no', 'yes') as 2nd_item_fav_brand
from users u
left join order_fav o
on u.user_id = o.seller_id and u.favorite_brand = o.item_brand and ranks=2