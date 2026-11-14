select state , group_concat(city order by city asc separator ', ') as cities
from cities
group by state
order by state asc