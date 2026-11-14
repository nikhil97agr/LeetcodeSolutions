with cte as (
    select
customer_id,
year(order_date) as year,
sum(price) as total
from orders
group by customer_id, year(order_date)


),
cte2 as (
    select
c1.customer_id,
count(c2.customer_id)+1 as total
from cte c1
left join cte c2
on c1.customer_id = c2.customer_id
and c2.year - c1.year = 1 and c2.total > c1.total
group by c1.customer_id
),
c3 as (
    select
    customer_id,
    count(distinct year(order_date)) as total
    from orders
    group by customer_id
)


select
c3.customer_id
from c3, cte2 
where c3.customer_id = cte2.customer_id
and c3.total = cte2.total