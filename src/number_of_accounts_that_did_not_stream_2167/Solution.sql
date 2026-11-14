select count(*) as accounts_count

from (select distinct(account_id) as id
from subscriptions 
where year(start_date) = 2021 or year(end_date) = 2021) sub
left join streams st
on sub.id = st.account_id and year(st.stream_date) = 2021
where st.account_id is null 