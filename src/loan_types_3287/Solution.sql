select user_id 
from (select distinct user_id 
from loans 
where loan_type = 'Refinance'
union all
select distinct user_id
from loans
where loan_type = 'Mortgage'
)data

group by user_id
having count(*) = 2
order by user_id asc