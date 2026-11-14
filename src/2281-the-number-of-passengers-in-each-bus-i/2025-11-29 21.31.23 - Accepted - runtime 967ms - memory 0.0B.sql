with cte as (
    select
    bus_id,
    arrival_time,
    row_number() over(order by arrival_time ) as ranks
    from buses
)

select 
c1.bus_id,
ifnull(count(p.passenger_id), 0) as passengers_cnt
from cte c1
left join cte c2
on c1.ranks-1 = c2.ranks
left join passengers p
on p.arrival_time <= c1.arrival_time and (c2.bus_id is null or c2.arrival_time < p.arrival_time)
group by c1.bus_id
order by c1.bus_id asc