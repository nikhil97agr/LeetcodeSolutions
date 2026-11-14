with cte as (
    select 
year(transaction_date) as year,
product_id,
sum(spend) as curr_year_spend,
row_number() over(partition by product_id order by year(transaction_date) asc) as ranks
from user_transactions
group by year, product_id
)

select 
c1.year,
c1.product_id,
c1.curr_year_spend,
c2.curr_year_spend as prev_year_spend,
case c2.curr_year_spend
when null
then null
else round((c1.curr_year_spend - c2.curr_year_spend)*100/c2.curr_year_spend, 2)
end as yoy_rate
from cte c1
left join cte c2
on c1.product_id = c2.product_id
and c1.ranks = c2.ranks + 1
order by c1.product_id asc, c1.year asc
