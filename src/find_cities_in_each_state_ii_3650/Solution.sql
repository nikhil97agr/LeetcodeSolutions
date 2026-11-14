
with cte as (
    select state, 
    group_concat(city  order by city asc separator ', ') as cities, 
    sum(if(left(state, 1) = left(city, 1), 1, 0)) as matching_letter_count
    from cities
    group by state
    having count(*) >= 3 and matching_letter_count > 0
    order by matching_letter_count desc, state asc



)

select * from cte;