with cte as (
    select 
    item_type,
    sum(square_footage) as total_foot,
    count(item_id) as total_item
    from inventory
    group by item_type
)

select
item_type,
total_item * floor(500000/total_foot) as item_count
from cte
where item_type = 'prime_eligible'
union 

select
item_type,
total_item * floor((500000%(select total_foot from cte where item_type = 'prime_eligible'))/total_foot) as item_count

from cte
where item_type = 'not_prime'