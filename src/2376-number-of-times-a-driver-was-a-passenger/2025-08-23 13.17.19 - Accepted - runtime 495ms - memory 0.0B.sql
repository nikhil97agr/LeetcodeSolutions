select r1.driver_id, count(r2.passenger_id) as cnt 
from (select distinct(driver_id) as driver_id from rides) r1
left join rides r2
on r1.driver_id = r2.passenger_id
group by r1.driver_id