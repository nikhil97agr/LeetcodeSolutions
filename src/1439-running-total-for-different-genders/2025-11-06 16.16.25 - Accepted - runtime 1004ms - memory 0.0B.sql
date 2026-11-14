with ranked_data as (
    select gender, day, rank() over(partition by gender order by day asc) as ranks, score_points
    from scores
)

select r1.gender, r1.day, sum(r2.score_points) as total
from ranked_data r1
join ranked_data r2
on r1.gender = r2.gender
where r2.ranks <= r1.ranks
group by r1.gender, r1.day
order by r1.gender, r1.day