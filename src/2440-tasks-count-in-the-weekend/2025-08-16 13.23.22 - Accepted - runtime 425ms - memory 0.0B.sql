select 
sum(case when date_format(submit_date, '%W') in ('Sunday', 'Saturday') then 1 else 0 end) as weekend_cnt, 
sum(case when date_format(submit_date, '%W') not in ('Sunday', 'Saturday') then 1 else 0 end) as working_cnt
from tasks
