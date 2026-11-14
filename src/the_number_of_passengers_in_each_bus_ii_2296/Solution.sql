with recursive bus_cte as (
    select 
    bus_id,
    arrival_time,
    lag(arrival_time, 1, 0) over(order by arrival_time) as last_bus_time,
    capacity,
    row_number() over(order by arrival_time) as bus_rnk
    from buses b
),
capacity as (
    select bus_id,
    bus_rnk,
    capacity,
    count(p.passenger_id) as new_pas_cnt

    from
    bus_cte b
    left join passengers p
    on (p.arrival_time <= b.arrival_time) and (p.arrival_time > b.last_bus_time)
    group by bus_id, bus_rnk, capacity
),
data as (
 select
  bus_id,
  capacity,
  1 as bus_order,
  if (new_pas_cnt > capacity, new_pas_cnt - capacity, 0) as spill,
  if(new_pas_cnt > capacity, capacity, new_pas_cnt) as passengers_cnt
  from capacity
where bus_rnk = 1
union
select
c.bus_id,
c.capacity,
d.bus_order + 1,
if(d.spill + c.new_pas_cnt > c.capacity, c.new_pas_cnt + d.spill - c.capacity, 0) as spill,
if(c.new_pas_cnt + d.spill > c.capacity, c.capacity, c.new_pas_cnt + d.spill) as passengers_cnt
from data d, capacity c
where d.bus_order + 1 = c.bus_rnk
)


select
bus_id,
passengers_cnt
from data
order by bus_id
