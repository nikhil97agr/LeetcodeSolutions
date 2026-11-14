with cte as (
    select
    num,
    sum(frequency) over(order by num) - frequency as lower_bound,
    sum(frequency) over(order by num) as upper_bound,
    (sum(frequency) over())/2 as medium_bound
    from numbers
)

select
avg(num) as median
from cte
where lower_bound <= medium_bound and medium_bound <= upper_bound