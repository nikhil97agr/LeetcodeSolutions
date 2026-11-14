with viewers as (
    select
user_id,
min(session_start) as session,
session_type,
count(session_start) as sessions_count
from sessions
group by user_id, session_type
)


select
v1.user_id,
v2.sessions_count
from viewers v1
join viewers v2
on v1.session_type = 'Viewer' and v2.session_type = 'Streamer' and v1.user_id = v2.user_id 
and v1.session < v2.session
order by v2.sessions_count desc, v1.user_id desc
