select candidate_id
from candidates
where skill = 'Python' or skill = 'Tableau' or skill = 'PostgreSQL'
group by candidate_id
having count(distinct(skill)) =3
order by candidate_id asc