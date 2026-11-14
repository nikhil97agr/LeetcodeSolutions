select N, 'Root' as Type
from tree
where p is null
union all
select t1.N, 'Leaf' as Type
from tree t1
left join tree t2 
on t1.N = t2.p 
where t2.p is null and t1.p is not null
union all
select t1.N, 'Inner' as Type
from tree t1
left join tree t2
on t1.N = t2.p and t1.p is not null
where t2.p is not null
group by t1.N
order by N asc
