select project_id
from (select project_id, rank() over( order by count(employee_id) desc) as ranked
from project
group by project_id

) s
where ranked = 1