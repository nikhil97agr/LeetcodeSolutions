with row_data as (
    select x, row_number() over(order by x desc) as row_num
    from point
)

select min(abs(p2.x - p1.x)) as shortest
from row_data p1
join row_data p2
on p1.row_num + 1 = p2.row_num