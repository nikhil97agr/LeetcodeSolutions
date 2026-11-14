with data as (select 
customer_id,
sum(amount) as total_amount,
count(transaction_id) as transaction_count,
count(distinct category) as unique_categories,
round(avg(amount),2) as avg_transaction_amount,
round(count(transaction_id)*10 + sum(amount)/100 , 2) as loyalty_score
from transactions t
join products p 
on t.product_id = p.product_id
group by customer_id),
top_category as (
    select
t.customer_id,
p.category,
rank() over(partition by customer_id order by count(*) desc, max(transaction_date) desc) as ranks
from transactions t
join products p
on p.product_id = t.product_id
group by t.customer_id, p.category
)




select
d.customer_id, 
total_amount,
transaction_count,
unique_categories,
avg_transaction_amount,
category as top_category, 
loyalty_score
from data d
join top_category c
on d.customer_id = c.customer_id and c.ranks = 1
order by loyalty_score desc, d.customer_id asc