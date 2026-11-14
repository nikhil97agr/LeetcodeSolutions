with data as (
    select product_id, max(change_date) as change_date
    from products p1
    where change_date <= '2019-08-16'
    group by product_id

),
distinct_id as (

    select distinct product_id as product_id
    from products
) 
select ids.product_id, ifnull(d.new_price, 10) as price
from distinct_id ids
left join
(
    select p.product_id, p.new_price
from products p
join data d
on p.product_id= d.product_id
and p.change_date = d.change_date
) d
on ids.product_id = d.product_id