with ny as (
    select count(*) as score

    from newyork
    where score >= 90
),
cal as (
    select count(*) as score
    from california
    where score >= 90
)

select 'New York University' as winner
from ny, cal
where ny.score > cal.score
union
select "California University" as winner
from ny, cal
where ny.score < cal.score
union
select "No Winner" as winner
from ny, cal
where ny.score = cal.score