with cte as (
    select
server_id,
status_time,
session_status,
row_number() over() as row_num
from servers
)

select 
floor((sum(timestampdiff(second, c1.status_time, c2.status_time)))/(60*60*24)) as total_uptime_days
from cte c1
join cte c2
on c1.server_id = c2.server_id 
where c1.row_num  < c2.row_num and c1.row_num%2=1 and c2.row_num%2=0 and c2.row_num - c1.row_num = 1
