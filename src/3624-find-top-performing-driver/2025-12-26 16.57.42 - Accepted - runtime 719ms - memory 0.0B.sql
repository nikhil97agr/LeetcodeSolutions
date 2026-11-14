with driver_vehicle as (
    select
    d.driver_id, 
    v.vehicle_id,
    accidents,
    fuel_type
    from drivers d
    join vehicles v
    on d.driver_id = v.driver_id
),
ratings as (
    select
    d.driver_id,
    d.fuel_type,
    round(avg(rating), 2) as rating,
    sum(distance) as dist,
    accidents
    from driver_vehicle d
    join trips t
    on t.vehicle_id = d.vehicle_id
    group by d.fuel_type, d.driver_id
),
ranked_data as (
    select
    driver_id,
    fuel_type,
    rating,
    dist,
    rank() over(partition by fuel_type order by rating desc, dist desc, accidents desc) as ranks
    from ratings
     
)

select fuel_type, driver_id, rating, dist as distance
from ranked_data
where ranks = 1
order by fuel_type