select 
c.name
from vote v
join candidate c
on c.id = v.candidateid
group by c.id
order by count(*) desc
limit 1