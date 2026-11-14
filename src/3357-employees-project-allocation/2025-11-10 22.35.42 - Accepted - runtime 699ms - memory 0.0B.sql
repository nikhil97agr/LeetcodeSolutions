with cte as (
    select
    e.employee_id,
    p.project_id, 
    e.name,
    e.team,
    ifnull(sum(p.workload), 0) as workload
    from employees e
    left join project p
    on e.employee_id = p.employee_id
    group by e.employee_id, p.project_id

),
team as (
    select 
    team,
    avg(workload) as average
    from cte
    group by team
)

select
c.employee_id,
c.project_id,
c.name as employee_name,
c.workload as project_workload

from cte c
left join team t
on c.team = t.team
where c.workload > t.average
order by c.employee_id asc, c.project_id asc