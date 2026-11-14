with cte as (
    select case when continent = 'America' then name end as America,
    case when continent = 'Asia' then name end as Asia,
    case when continent ='Europe' then name end as Europe,
    row_number() over(partition by continent order by name) as rnk
    from student
)


select min(america) as america, min(asia) as asia, min(europe) as europe
from cte
group by rnk