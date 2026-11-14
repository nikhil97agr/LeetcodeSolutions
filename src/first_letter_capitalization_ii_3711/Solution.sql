with recursive cte as (
    select
    content_id,
    content_text,
    1 as len,
    substring(content_text from 1 for 1) as curr,
    ' ' as prev

    from user_content

    union all

    select
    content_id,
    content_text,
    len + 1,
    substring(content_text from len + 1 for 1) as curr,
    substring(content_text from len for 1) as prev
    from cte

    where len < length(content_text)

)

select
content_id,
content_text as original_text,
group_concat(
    case when prev = ' ' or prev = '-'
    then upper(curr)
    else lower(curr)
    end
    order by len
    separator ''
) as converted_text
from cte
group by content_id