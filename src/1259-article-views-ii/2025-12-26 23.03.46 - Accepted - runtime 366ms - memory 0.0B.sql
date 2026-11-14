with cte as (
    select
    viewer_id,
    count(distinct article_id) as count
    from views
    group by view_date, viewer_id
)

select distinct viewer_id as id
from cte
where count > 1
order by id asc