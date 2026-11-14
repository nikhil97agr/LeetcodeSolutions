with request as (
    select count( distinct concat(sender_id, '-', send_to_id)) as cnt
    from friendrequest
),
accept as (
    select count(distinct concat(requester_id, '-', accepter_id)) as cnt
    from requestaccepted
)

select 
round(if(r.cnt =0, 0.00, a.cnt/r.cnt), 2) as accept_rate
from request r, accept a