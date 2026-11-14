with cte as (
    select id, drink, row_number() over() as row_num
    from coffeeshop
),
cte2 as (
    select
    c1.id,
    c1.row_num,
    max(c2.row_num) as max_row
    from cte c1
    join cte c2
    on c1.row_num >= c2.row_num and c2.drink is not null
    group by c1.id

)


select
c2.id,
c1.drink
from cte c1
join cte2 c2
on c1.row_num = c2.max_row
order by c2.row_num asc