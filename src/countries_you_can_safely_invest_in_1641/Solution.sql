with cte as (
    select
id,
c.name,
country_code
from person p
join country c
on country_code = substring(phone_number, 1, 3)
),
global as (
    select 
    avg(duration) as global_average
    from calls
),
local as (
    select
c1.name,
sum(c2.duration) as total_duration,
count(c2.callee_id) as total_calls
from cte c1
join calls c2
on c1.id = c2.caller_id
group by c1.name

union all

select 
c1.name,
sum(c2.duration) as total_duration,
count(c2.callee_id) as total_calls
from cte c1
join calls c2
on c1.id = c2.callee_id
group by c1.name
),
result as (
    select
l.name,
g.global_average,
sum(total_duration)/sum(total_calls) as local_average
from 
local l, global g
group by l.name

)

select 
name as country
from result
where local_average > global_average