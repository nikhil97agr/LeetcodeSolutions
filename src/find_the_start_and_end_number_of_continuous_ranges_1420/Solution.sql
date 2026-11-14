with ranked_data as (
    select log_id, rank() over(order by log_id)  as ranks
from logs
)

select min(log_id) as start_id, max(log_id) as end_id
from ranked_data
group by log_id - ranks