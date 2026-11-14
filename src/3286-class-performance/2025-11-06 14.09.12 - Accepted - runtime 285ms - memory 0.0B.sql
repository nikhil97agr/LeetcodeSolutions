with cte as (
    select assignment1 + assignment2 + assignment3 as score 
    from scores
)

select max(score) - min(score) as difference_in_score from cte
