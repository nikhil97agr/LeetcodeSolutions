select user_id
from emails e
join texts t
on e.email_id = t.email_id
where signup_action = "Verified"
and Date(action_date) = DATE_ADD(Date(signup_date), interval 1 day)
order by user_id asc