select candidate_id
from candidates c
left join rounds r
on c.interview_id = r.interview_id and c.years_of_exp >=2
group by candidate_id
having sum(score) > 15