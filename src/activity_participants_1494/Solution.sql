with cte as (
    select a.name, count(*) as cnt
from activities a
left join friends f
on a.name = f.activity
group by a.name
)

select name as activity
from cte 
where cnt != (select max(cnt) from cte) and cnt != (select min(cnt) from cte)