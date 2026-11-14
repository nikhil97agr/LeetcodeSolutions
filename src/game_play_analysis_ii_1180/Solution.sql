with ranked_data as (
    select player_id, device_id, rank() over(partition by player_id order by event_date asc) as ranks
    from activity

)

select player_id, device_id
from ranked_data
where ranks = 1