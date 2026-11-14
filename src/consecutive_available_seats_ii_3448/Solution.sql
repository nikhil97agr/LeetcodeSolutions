with cte as (
    select
seat_id,
rank() over(order by seat_id) as ranks
from cinema
where free = 1
),
t2 as (
    select
min(seat_id) as first_seat_id,
max(seat_id) as last_seat_id,
count(*) as consecutive_seats_len
from cte
group by seat_id - ranks
order by first_seat_id
)

select
first_seat_id,
last_seat_id,
consecutive_seats_len
from t2
where consecutive_seats_len = (select max(consecutive_seats_len) from t2)
