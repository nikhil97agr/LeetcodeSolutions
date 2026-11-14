with approved as (
    select substring(trans_date, 1, 7) as month,
    country,
    count(*) as approved_count,
    sum(amount) as approved_amount
    from transactions
    where state = 'approved'
    group by month, country
    having approved_count <> 0
),
charge as (
    select
    substring(c.trans_date, 1, 7) as month,
    t.country,
    count(*) as chargeback_count,
    sum(amount) as chargeback_amount
    from transactions t
    join chargebacks c
    on t.id = c.trans_id
    group by month, country
)


select 
month,
country,
sum(approved_count) as approved_count,
sum(approved_amount) as approved_amount,
sum(chargeback_count) as chargeback_count,
sum(chargeback_amount) as chargeback_amount
from (select 
a.month,
a.country,
ifnull(a.approved_count, 0) as approved_count,
ifnull(a.approved_amount, 0) as approved_amount,
0 as chargeback_count,
0 as chargeback_amount
from charge c
right join approved a
on c.month = a.month and a.country = c.country
union all 
select 
c.month,
c.country,
0 as approved_count,
0 as approved_amount,
ifnull(c.chargeback_count, 0) as chargeback_count,
ifnull(c.chargeback_amount, 0) as chargeback_amount
from charge c
left join approved a
on c.month = a.month and a.country = c.country
) t
group by month, country