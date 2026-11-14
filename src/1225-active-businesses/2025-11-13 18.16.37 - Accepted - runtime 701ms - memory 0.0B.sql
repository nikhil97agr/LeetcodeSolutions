with cte as (
    select
    event_type,
    avg(occurrences) as average
    from events
    group by event_type
)


select business_id
from events e
left join cte
on e.event_type = cte.event_type
where e.occurrences > cte.average
group by business_id
having count(*) > 1
