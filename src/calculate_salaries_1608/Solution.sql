select s1.company_id, s1.employee_id, s1.employee_name, if(s2.salary < 1000, s1.salary, round(if(s2.salary >= 1000 and s2.salary <= 10000, s1.salary - (24*s1.salary)/100, s1.salary - (49*s1.salary)/100))) as salary
from salaries s1
left join
(select company_id, max(salary) as salary from salaries group by company_id) s2
on s1.company_id = s2.company_id
