with cte as (
    select 
    x,
    y,
    row_number() over() as num
    from point2d
),
c as (
    select
    round(sqrt((c1.x - c2.x)*(c1.x - c2.x) + (c1.y - c2.y)*(c1.y - c2.y)),2) as dist
    from cte c1
    join cte c2
    on c1.num <> c2.num

)

select 
min(dist) as shortest
from c