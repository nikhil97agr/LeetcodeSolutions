select c.country_name, case when avg(weather_state) <= 15 then 'Cold'
when avg(weather_state) >= 25 then "Hot"
else "Warm"
end as Weather_type
from countries c
join weather w
on c.country_id = w.country_id
where month(w.day) = 11 and year(w.day) = 2019
group by w.country_id