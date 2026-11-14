with cte as (
    select
car_id,
sum(fee_paid) as total_fee_paid,
round(sum(fee_paid)/(sum(timestampdiff(minute, entry_time, exit_time))/60), 2) as avg_hourly_fee
from parkingtransactions
group by car_id
),
cte2 as (
    select
lot_id,
car_id,
rank() over(partition by car_id order by sum(timestampdiff(minute, entry_time, exit_time))/60 desc) as ranks
from parkingtransactions
group by car_id, lot_id
)

select
c1.car_id,
c1.total_fee_paid,
c1.avg_hourly_fee,
c2.lot_id as most_time_lot
from cte c1
join cte2 c2
on c1.car_id = c2.car_id
where ranks = 1