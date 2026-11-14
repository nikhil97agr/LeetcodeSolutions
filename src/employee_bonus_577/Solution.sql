# Write your MySQL query statement below
select name, bonus
from employee e
left join bonus b
on b.empId = e.empId
where b.bonus < 1000 or b.bonus is null