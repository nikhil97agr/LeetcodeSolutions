

select id, 'Root' as type
from tree 
where p_id is null

union

select t1.id, 'Leaf' as type
from tree t1
left join tree t2
on t1.id = t2.p_id
where t1.p_id is not null and t2.p_id is null

union

select t1.id, 'Inner' as type
from tree t1
left join tree t2
on t1.id = t2.p_id
where t1.p_id is not null and t2.p_id is not null