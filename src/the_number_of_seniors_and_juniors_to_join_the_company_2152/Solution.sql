with seniors as (
    select *, sum(salary) over (order by salary) as cum_salary
    from candidates
    where experience='Senior'
),
junior as (
    select *, sum(salary) over (order by salary) as cum_salary
    from candidates
    where experience='Junior'
)

select 'Senior' as experience, count(*) as accepted_candidates
from seniors
where cum_salary <= 70000
union
select 'Junior' as experience, count(*) as accepted_candidates
from junior
where cum_salary <= 70000 - ifnull((select max(cum_salary) from seniors where cum_salary <= 70000),0)

