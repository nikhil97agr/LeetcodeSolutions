with recursive  cte as (
    select 
    trim(substring_index(tweet, ' ', 1)) as hashtag,
    substring(tweet, length(substring_index(tweet, ' ', 1))+2) as remaining
    from tweets

    union all

    select
    trim(substring_index(remaining, ' ', 1)),
    substring(remaining, length(substring_index(remaining, ' ', 1))+2)
    from cte
    where remaining <> ''
)


select
hashtag,
count(*) as count
from cte
where hashtag regexp '^#[a-zA-Z0-9]+'
group by hashtag
order by count desc, hashtag desc
limit 3