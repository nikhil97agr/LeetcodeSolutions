with recursive numbers as (
    select task_id, 1 as subtask_id, subtasks_count
    from tasks
    union all
     select task_id, subtask_id + 1 as subtask_id, subtasks_count
     from numbers
     where subtask_id + 1 <= subtasks_count
)


select task_id, subtask_id
from numbers
where (task_id, subtask_id) not in (select task_id, subtask_id
from numbers
intersect 
select task_id, subtask_id
from executed)