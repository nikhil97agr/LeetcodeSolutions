with cte as (
    select
customer_id,
transaction_date,
rank() over(partition by customer_id order by transaction_date asc) as ranks
from transactions

),
cte2 as (
    select 
c1.customer_id,
c1.transaction_date,
count(c2.transaction_date) as total
from cte c1
join cte c2
on c1.customer_id = c2.customer_id 
where c1.transaction_date <= c2.transaction_date
and datediff(c2.transaction_date, c1.transaction_date) = c2.ranks - c1.ranks
group by c1.customer_id, c1.transaction_date

)

select customer_id
from cte2
where total = (select max(total) from cte2)
order by customer_id asc