with data as (
    select t.client_id, t.driver_id, t.status, t.request_at
    from trips t
    join users u1
    on t.client_id = u1.users_id
    and u1.banned = "No"
    join users u2
    on t.driver_id = u2.users_id
    and u2.banned = "No"
    where request_at between "2013-10-01" and "2013-10-03"

)
select request_at as Day, round(sum(case when status like "cancelled%" then 1 else 0 end)/count(status) ,2) as "Cancellation Rate"
from data
group by request_at
