with valid_date as (
    select
a.customer_id,
a.transaction_date
from transactions a
join transactions b
on b.amount > a.amount
and a.customer_id = b.customer_id
 and datediff(b.transaction_date, a.transaction_date) = 1

),
ranked_date as (
    select
customer_id,
transaction_date,
rank() over(partition by customer_id order by transaction_date) as row_num
from valid_date
),
grouped_date as (
    select
customer_id,
transaction_date,
date_sub(transaction_date, interval row_num day) as id
from ranked_date
),
data as (
    select
customer_id,
min(transaction_date) as consecutive_start,
count(*) total_transactions
from grouped_date
group by customer_id, id
)

select
customer_id,
consecutive_start,
date_add(consecutive_start, interval total_transactions day) as consecutive_end
from data
where total_transactions > 1
order by customer_id, consecutive_start, consecutive_end





