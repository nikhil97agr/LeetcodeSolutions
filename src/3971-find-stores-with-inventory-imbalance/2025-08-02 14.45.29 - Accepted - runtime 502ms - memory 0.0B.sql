with data as (
    select i.store_id, s.store_name, s.location
    from inventory i
    join stores s
    on s.store_id = i.store_id
    group by i.store_id
    having count(distinct i.product_name) >= 3
),
rankedData as (
    select s.store_id, s.store_name, s.location, i.product_name, rank() over(partition by i.store_id order by i.price asc) as min_price, rank() over(partition by i.store_id order by i.price desc) as max_price,  i.quantity
    from data s
    join inventory i
    on s.store_id = i.store_id
)

select d1.store_id, d1.store_name, d1.location, d2.product_name as most_exp_product, d1.product_name as cheapest_product, round(d1.quantity/d2.quantity, 2) as imbalance_ratio
from rankedData d1
join rankedData d2
on d1.store_id = d2.store_id
and d1.min_price = 1
and d2.max_price = 1

where d1.quantity > d2.quantity
order by imbalance_ratio desc, d1.store_name asc

