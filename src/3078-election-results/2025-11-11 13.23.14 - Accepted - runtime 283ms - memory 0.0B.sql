with voter as (
    select voter, 1 / count(*) as share
    from votes
    where candidate is not null
    group by voter
),
 candidate as (
    select 
    v1.candidate, sum(v2.share) as total_votes
    from votes v1
    join voter v2
    on v1.voter = v2.voter
    group by v1.candidate
)


select candidate
from candidate
where total_votes = (select max(total_votes) from candidate) 
order by candidate asc