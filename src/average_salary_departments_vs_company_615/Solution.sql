with company as (
    select
    concat(year(pay_date),'-',lpad(month(pay_date), 2, '0')) as pay_month,
    avg(amount) as avg_salary
    from salary
    group by pay_month
),
dept as (
    select
    concat(year(pay_date),'-',lpad(month(pay_date), 2, '0')) as pay_month,
    department_id,
    avg(amount) as avg_salary
    from salary s
    join employee e
    on s.employee_id = e.employee_id
    group by pay_month, department_id

    
)

select
c.pay_month,
d.department_id,
if(
    d.avg_salary > c.avg_salary,
    'higher',
    if(
        d.avg_salary < c.avg_salary,
        'lower',
        'same'
    )
) as comparison
from company c
join dept d
on c.pay_month = d.pay_month
