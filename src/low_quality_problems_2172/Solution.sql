select problem_id
from problems
where (likes*100)/(likes + dislikes) < 60
order by problem_id asc