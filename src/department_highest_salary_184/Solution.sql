select
Department, name as Employee, d.Salary
from (select d.id, d.name as Department, max(salary) as Salary
from department d
left join employee e
on d.id = e.departmentid
group by d.name
) d

left join employee e
on e.departmentId = d.id
where e.salary = d.salary