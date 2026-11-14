with prices as (
    select seller_id, sum(price) as max_price
    from sales
    group by seller_id
)

select seller_id
from prices
where max_price = (select max(max_price) from prices)