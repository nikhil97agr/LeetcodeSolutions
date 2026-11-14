with cte as (select user_id, spend, 
transaction_date,
row_number() over(partition by user_id order by transaction_date asc) as ranks
from transactions)


select 
c1.user_id, 
c1.spend as third_transaction_spend,
c1.transaction_date as third_transaction_date
from cte c1
join cte c2
on c1.user_id = c2.user_id and c1.ranks = 3
where c2.ranks < c1.ranks and c2.spend < c1.spend
group by c1.user_id
having count(*) = 2
order by c1.user_id asc