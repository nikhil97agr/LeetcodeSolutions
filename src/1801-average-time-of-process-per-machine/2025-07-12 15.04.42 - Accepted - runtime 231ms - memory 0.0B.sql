select t.machine_id, round((sum(t.timestamp)*2)/count(t.activity_type), 3) as processing_time

from (
    select machine_id, activity_type, -timestamp as timestamp
    from activity
    where activity_type = 'start'

    union
    select machine_id, activity_type, timestamp
    from activity
    where activity_type = 'end'
) as t

group by t.machine_id
