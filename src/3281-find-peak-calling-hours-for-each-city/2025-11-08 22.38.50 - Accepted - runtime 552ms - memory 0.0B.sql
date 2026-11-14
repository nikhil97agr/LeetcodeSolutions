select city, calling_hour as peak_calling_hour, cnt as number_of_calls
from ( 
    select city, hour(call_time) calling_hour, count(*) as cnt, rank() over(partition by city order by count(*) desc) as ranks
from calls
group by city, hour(call_time)
) data
where ranks = 1
order by peak_calling_hour desc, city desc