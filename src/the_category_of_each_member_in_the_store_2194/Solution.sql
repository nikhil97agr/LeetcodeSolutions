



select member_id, name,

case 
    when visited = 0 then 'Bronze'
    when (100*purchase)/visited < 50 then 'Silver'
    when (100*purchase)/visited < 80 then 'Gold'
    else 'Diamond'
end as category
 from (select m.member_id, m.name, sum(if(v.visit_id is null, 0, 1))   as visited, sum(if(p.visit_id is null, 0, 1)) as purchase
from members m
left join visits v
on m.member_id = v.member_id
left join purchases p
on v.visit_id = p.visit_id
group by m.member_id
) data
