select 
policy_id,
state,
fraud_score
from 
(select
policy_id,
state,
percent_rank() over(partition by state order by fraud_score desc) as ranks,
fraud_score
from fraud

) data
where ranks <= 0.05
order by
state,
fraud_score desc,
policy_id