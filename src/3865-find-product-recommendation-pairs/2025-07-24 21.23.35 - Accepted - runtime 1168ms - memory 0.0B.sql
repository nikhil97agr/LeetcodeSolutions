with data as (
    select p1.product_id, p2.user_id, p1.category
    from productInfo p1
    inner join productpurchases p2
    on p1.product_id = p2.product_id
    
)


select d1.product_id as product1_id,
d2.product_id as product2_id,
d1.category as product1_category,
d2.category as product2_category,
count(distinct(d1.user_id)) as customer_count
from data d1
inner join data d2
on d1.user_id = d2.user_id
where d1.product_id < d2.product_id
group by d1.product_id, d2.product_id
having customer_count >= 3
order by customer_count desc, product1_id asc, product2_id asc