with categories as(
    select p1.category as c1, p2.category as c2
    from productinfo p1
    join productinfo p2
    on p1.category < p2.category 
    group by p1.category, p2.category

),
product as (
    select user_id, category
    from productpurchases p1
    join productinfo p2
    on p1.product_id = p2.product_id
    group by user_id, category
)

select c.c1 as category1, c.c2 as category2, count(distinct(p1.user_id)) as customer_count
from product p1
join product p2
on p1.user_id = p2.user_id
join categories c
on c.c1 = p1.category
and c.c2 = p2.category
group by c.c1, c.c2
having customer_count >=3
order by customer_count desc, category1 asc, category2 asc