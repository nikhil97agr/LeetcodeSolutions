with recursive month as (
    select 1 as month
    union
    select month + 1 as month from month where month < 12
),
month_rides as (
    select
month(r.requested_at) as month,
sum(a.ride_distance) as ride_distance,
sum(a.ride_duration) as ride_duration
from rides r
join acceptedrides a
on r.ride_id = a.ride_id
where year(r.requested_at) = 2020
group by month
),
all_months as (
    select
m.month,
ifnull(mr.ride_distance, 0) as ride_distance,
ifnull(mr.ride_duration, 0) as ride_duration
from month m
left join month_rides mr
on m.month = mr.month
)


select
a.month,
round((a.ride_distance + b.ride_distance + c.ride_distance)/3, 2) as average_ride_distance,
round((a.ride_duration + b.ride_duration + c.ride_duration)/3, 2) as average_ride_duration
from all_months a
join all_months b
join all_months c
on a.month = b.month - 1 and a.month = c.month - 2