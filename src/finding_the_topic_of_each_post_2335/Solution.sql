with data as (
    select
distinct post_id,
topic_id
from posts p
left join keywords k
on concat(' ',content, ' ') like concat('% ', word,' %')
)


select
post_id,
if(
    topic_id is null,
    'Ambiguous!',
    group_concat(topic_id order by topic_id asc)
) as topic
from data
group by post_id
