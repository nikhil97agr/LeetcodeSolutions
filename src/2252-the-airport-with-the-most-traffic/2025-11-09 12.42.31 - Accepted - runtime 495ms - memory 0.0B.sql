with data as (select id, sum(cnt) as cnt
from (select departure_airport as id, sum(flights_count) as cnt
from flights
group by id
union all
select arrival_airport as id, sum(flights_count) as cnt
from flights
group by id
) d
group by id
)


select id as airport_id from data
where cnt = (select max(cnt) from data)