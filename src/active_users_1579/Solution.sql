with cte as (
    select distinct id as id, login_date from logins
),
cte1 as (
    select id, login_date, row_number() over(partition by id order by login_date asc) as ranks
    from cte

),

cte2 as (
    select distinct l.id as id
    from cte1 l
    join cte1 r
    on l.id = r.id 
    where l.ranks <= r.ranks and datediff(r.login_date, l.login_date) = r.ranks - l.ranks
    group by l.id, l.login_date
    having count(*) >=5

)



select a.id, name
from accounts a
join cte2 c
on a.id = c.id

order by a.id asc