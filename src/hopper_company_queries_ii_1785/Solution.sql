with recursive dates as (
    select 1 as month, 2020 as year

    union all

    select month + 1, year
    from dates
    where month < 12
) ,
active_drivers as (
    select
2020 as year,
1 as month,
count(driver_id) as active_drivers
from 
drivers
where
(year(join_date) = 2020 and month(join_date) = 1) or year(join_date) < 2020
union all

select 
2020 as year,
month(join_date) as month,
count(driver_id) as active_drivers
from drivers
where year(join_date) = 2020 and month(join_date) <> 1
group by month(join_date)
),
active as (
    select
d.month,
ifnull(active_drivers, 0) as active_drivers 
from dates d 
left join active_drivers a 
on d.month = a.month

),
data as (
    select 
month,
sum(active_drivers) over(order by month) as active_drivers
from active
),
ride as (
    select
month(requested_at) as month,
count(distinct driver_id) as total_drivers
from rides r
left join acceptedrides a
on a.ride_id = r.ride_id
where year(requested_at) = 2020
group by month(requested_at)
)

select
a.month,
round(ifnull((r.total_drivers*100)/a.active_drivers, 0), 2) as working_percentage
from data a 
left join ride r
on a.month = r.month