select employee.employee_id, employee.department_id
from employee, ( select employee_id, department_id, count(employee_id) as total from employee group by employee_id) e
where employee.employee_id = e.employee_id and (e.total = 1 or employee.primary_flag = 'Y')
