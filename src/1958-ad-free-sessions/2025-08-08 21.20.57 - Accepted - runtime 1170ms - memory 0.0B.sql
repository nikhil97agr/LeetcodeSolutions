select session_id
from playback
where session_id not in (select distinct(session_id)
from playback p
join ads a
on p.customer_id = a.customer_id
where p.start_time <= a.timestamp and a.timestamp <= p.end_time)