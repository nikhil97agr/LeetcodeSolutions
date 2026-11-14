with platform as (
    select 'Android' as platform
    union
    select 'IOS' as platform
    union
    select 'Web' as platform
),
experiment as (
    select 'Programming' as names
    union
    select 'Sports' as names
    union
    select 'Reading' as names
),
cte as (
    select 
    p.platform,
    e1.names
    from platform p, experiment e1
)

select
c.platform,
c.names as experiment_name,
count(experiment_id) as num_experiments
from cte c
left join experiments e
on c.platform = e.platform and c.names = e.experiment_name
group by c.platform, c.names

