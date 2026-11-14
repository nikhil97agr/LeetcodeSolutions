select d.name as department, e.name as employee, e.salary
from department d, (select name, salary, 
dense_rank() over (partition by departmentId order by salary desc) as top_salary,
departmentId
from employee) e
where e.departmentId = d.id
and top_salary <= 3
