with ranked_data as (
    select capacity, passenger_id, rank() over(partition by p.flight_id order by booking_time asc) as ranks
    from flights f
    join passengers p
    on f.flight_id= p.flight_id
)

select passenger_id, if(ranks > capacity, 'Waitlist', 'Confirmed') as Status
from ranked_data
order by passenger_id asc