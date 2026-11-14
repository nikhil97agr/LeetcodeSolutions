with cte as (


    select
    username,
    activity,
    startdate,
    enddate,
    row_number() over(partition by username order by startDate desc) as rn,
    count(*) over(partition by username) as cnt
    from useractivity

)

select
username,
activity,
startdate,
enddate
from cte
where rn = 2 or (rn = 1 and cnt = 1)