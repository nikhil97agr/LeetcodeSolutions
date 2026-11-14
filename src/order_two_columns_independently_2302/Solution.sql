
with another as (
    select second_col, row_number() over(order by second_col desc) as ranked
    from data

),
 first as (
    select first_col, row_number() over(order by first_col asc) as ranked
    from data
)

select first_col, second_col
from first, another
where first.ranked = another.ranked
order by first_col asc, second_col desc