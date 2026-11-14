with cte as (
    select 
    x, y, row_number() over() as row_num
    from coordinates
)

select
distinct c1.x,
c1.y
from cte c1
left join cte c2
on c1.row_num <> c2.row_num and c1.x = c2.y and c1.y = c2.x
where c1.x <= c1.y and c2.x is not null
order by c1.x asc, c1.y asc