with cte as (
    select
user_id,
count(prompt) as prompt_count,
round(avg(tokens), 2) as avg_tokens
from prompts
group by user_id
having prompt_count >= 3
)

select
c.user_id,
c.prompt_count,
c.avg_tokens
from cte c
join prompts p
on c.user_id = p.user_id
where tokens > avg_tokens
group by c.user_id
order by c.avg_tokens desc, c.user_id