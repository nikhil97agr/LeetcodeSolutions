with data as (select customer_id, 
sum(if(transaction_type = 'purchase', 1, 0)) as purchase, 
(sum(if(transaction_type = 'refund', 1, 0))/count(*))*100 as refund, datediff(max(transaction_date), min(transaction_date)) as days
from customer_transactions
group by customer_id
having purchase >= 3 and refund < 20 and days >= 30
order by customer_id asc)


select customer_id from data
