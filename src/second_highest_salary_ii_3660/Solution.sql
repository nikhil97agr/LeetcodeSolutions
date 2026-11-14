with ranked_data as (
    select emp_id, dept, dense_rank() over(partition by dept order by salary desc) as 'ranks'
    from employees
)


select emp_id, dept
from ranked_data
where ranks = 2
order by emp_id asc