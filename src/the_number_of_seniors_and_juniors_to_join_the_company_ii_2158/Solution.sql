with cte as (
    select 
employee_id,
experience,
sum(salary) over(partition by experience order by salary asc) as sums
from candidates
),
t1 as (
    select
employee_id,
sums 
from cte
where sums <= 70000
and experience = 'Senior'
)


select
employee_id
from cte
where sums <= (70000 - ifnull((select max(sums) from t1), 0)) 
and experience = 'Junior'

union 
select employee_id
from t1