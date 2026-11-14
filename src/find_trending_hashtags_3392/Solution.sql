with cte as (select concat("#", substring_index(substring_index(tweet, '#', -1), ' ', 1)) as hashtag
from tweets)


select hashtag, count(*) as hashtag_count
from cte
group by hashtag
order by hashtag_count desc, hashtag desc
limit 3