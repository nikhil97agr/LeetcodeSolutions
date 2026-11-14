with data as (
    select e.employee_id, e.name, rating, rank() over(partition by r.employee_id order by r.review_date desc) as rating_rank
    from employees e
    left join performance_reviews r
    on e.employee_id = r.employee_id
    
    
)


select d1.employee_id, d2.name, (d1.rating - d3.rating ) as improvement_score
from data d1
inner join data d2
on d1.employee_id = d2.employee_id
inner join data d3
on d1.employee_id = d3.employee_id
where
d1.rating_rank = 1
and d2.rating_rank = 2
and d3.rating_rank = 3
and d1.rating > d2.rating and d2.rating > d3.rating
order by improvement_score desc, name asc
