with ranked_data as (
    select id, company, salary, dense_rank() over(partition by company order by salary asc, id asc) as ranks
    from employee
),
 data as (
    select company, count(*) as cnt
from employee
group by company
)


select id, d.company, salary
from data d
left join ranked_data rd
on d.company = rd.company
where ranks = if(cnt%2=0, cnt/2, (cnt+1)/2) or ranks = if(cnt%2=0, (cnt+2)/2, (cnt+1)/2)