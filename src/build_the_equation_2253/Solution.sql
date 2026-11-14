with cte as (
    select
power,
concat(
    if(factor < 0, '-', '+'),
    abs(factor),
    if(power > 1,
        concat('X^', power),
        if(
            power = 1,
            'X',
            ''
        )
    )


) as eq

from terms
)

select 
concat(group_concat(
    eq order by power desc separator ''
), "=0") as equation
from cte
