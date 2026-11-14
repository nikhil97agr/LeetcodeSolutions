with engineering as (
    select max(salary) as eng
    from salaries
    where department = 'Engineering'
),
marketing as (
    select max(salary) as mark
    from salaries
    where department = 'Marketing'
)


select abs(eng - mark) as salary_difference
from engineering, marketing