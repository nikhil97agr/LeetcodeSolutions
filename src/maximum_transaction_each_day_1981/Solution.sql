select transaction_id
from transactions
where (date(day), amount) in (select date(day) as t_date, max(amount) as amt
from transactions
group by date(day))
order by transaction_id