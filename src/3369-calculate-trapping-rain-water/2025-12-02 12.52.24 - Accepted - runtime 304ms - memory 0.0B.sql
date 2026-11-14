with cte as (select
id,
max(height) over(order by id asc) as left_height,
max(height) over(order by id desc) as right_height,
height 
from heights
)


select
sum(if(left_height < right_height, left_height, right_height) - height) as total_trapped_water
from cte
