
select f.driver_id, f.driver_name, round(f.fuel, 2) as first_half_avg, round(s.fuel, 2) as second_half_avg, round(s.fuel - f.fuel, 2) as efficiency_improvement
from (
    select d.driver_id, d.driver_name, avg(distance_km/fuel_consumed) as fuel
    from drivers d, trips t
    where d.driver_id = t.driver_id
    and extract(month from trip_date) <= 6
    group by d.driver_id

) f, (
    select d.driver_id, d.driver_name, avg(distance_km/fuel_consumed) as fuel
    from drivers d, trips t
    where d.driver_id = t.driver_id
    and extract(month from trip_date) > 6
    group by d.driver_id

) s
where f.driver_id= s.driver_id
and f.fuel > 0
and s.fuel > 0
and f.fuel <= s.fuel

order by efficiency_improvement desc, driver_name asc