with trial as (
    select user_id, round(avg(activity_duration),2) as trial
    from useractivity
    where activity_type='free_trial'
    group by user_id
),
paid as (
    select user_id, round(avg(activity_duration),2) as paid
    from useractivity
    where activity_type='paid'
    group by user_id
)


select trial.user_id, trial.trial as trial_avg_duration, paid.paid as paid_avg_duration
from  trial, paid
where trial.user_id = paid.user_id

order by trial.user_id asc