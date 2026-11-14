with ranked_data as (
    select  account_id, day, rank() over(partition by account_id order by day asc) as ranks, type, amount
    from transactions 
)


select r1.account_id, r1.day, sum(if(r2.type = 'Deposit', r2.amount, -r2.amount)) as balance
from ranked_data r1
left join ranked_data r2
on r1.account_id = r2.account_id and r1.ranks >= r2.ranks
group by r1.account_id, r1.day 
order by r1.account_id, r1.day