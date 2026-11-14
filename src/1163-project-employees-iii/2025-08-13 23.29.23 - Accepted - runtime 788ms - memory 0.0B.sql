with ranked_data as (
    select project_id, p.employee_id, rank() over(partition by project_id order by e.experience_years desc ) as ranks
    from project p
    join employee e
    on p.employee_id = e.employee_id
)

select project_id, employee_id
from ranked_data
where ranks = 1