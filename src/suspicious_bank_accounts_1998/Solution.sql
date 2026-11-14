with cte as (
    select
    account_id, 
    sum(amount) as amt,
    year(day) as year,
    month(day) as month
    from transactions
    where type='Creditor'
    group by account_id, year,month
),
account as (
    select
    a.account_id,
    max_income,
    amt,
    month,
    year
    from accounts a
    join cte c
    on a.account_id = c.account_id

),
ranks as (
    select
a.account_id,
a.amt as a1,
b.amt as a2,
a.max_income
from account a
join account b
on a.account_id = b.account_id
and (a.month = b.month + 1 and a.year =b.year) or (a.year = b.year + 1 and a.month = 1 and b.month = 12)
)





select distinct account_id as account_id
from ranks
where a1 > max_income and a2 > max_income