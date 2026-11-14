
select
distinct r1.account_id
from loginfo r1
join loginfo r2
on r1.account_id = r2.account_id and r1.ip_address <> r2.ip_address
where (r1.login <= r2.login and r2.login < r1.logout) 
or 
(r1.login <= r2.logout and r2.logout <= r1.logout)
or
(r2.login <= r1.login and r1.login < r2.logout) 
or 
(r2.login <= r1.logout and r1.logout <= r2.logout)