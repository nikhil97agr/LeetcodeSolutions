with cte as (
    select '[0-5>' as bin
    union 
    select '[5-10>' as bin
    union 
    select '[10-15>' as bin
    union
    select '15 or more' as bin
),
cte2 as (
    select
case 
    when duration/60 < 5 then '[0-5>'
    when duration/60 < 10 then '[5-10>'
    when duration/60 < 15 then '[10-15>'
    else '15 or more'
    end
    as bin,
    count(*) as total
from sessions
group by bin
)

select cte.bin, ifnull(cte2.total, 0) as total
from cte
left join cte2
on cte.bin = cte2.bin