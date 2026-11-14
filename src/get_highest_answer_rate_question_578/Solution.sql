select survey_log
from (
    select
question_id as survey_log,
(sum(if(action = 'show', 0, 1))/count(*))*100 as answer_rate
from surveylog
where action <> 'skip'
group by question_id
order by answer_rate desc, question_id asc
limit 1
) t