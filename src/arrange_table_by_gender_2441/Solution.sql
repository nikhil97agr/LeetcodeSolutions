with cte as (
    select user_id, gender, rank() over(partition by gender order by user_id asc) as ranks
    from genders
)

select user_id, gender
from cte
order by ranks asc, gender asc