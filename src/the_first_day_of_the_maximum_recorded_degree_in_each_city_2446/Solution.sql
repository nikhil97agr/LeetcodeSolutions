with cte as(
select city_id, day, degree, rank() over(partition by city_id order by degree desc, day asc) as ranks
from weather)


select city_id, day, degree
from cte 
where ranks = 1
order by city_id asc