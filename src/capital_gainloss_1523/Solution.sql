select s.stock_name, sum(s.price) as capital_gain_loss
from (
    select stock_name, price
    from stocks 
    where operation = 'Sell'

    union all
    select stock_name, -price as price
    from stocks
    where operation = 'Buy'
) s

group by s.stock_name