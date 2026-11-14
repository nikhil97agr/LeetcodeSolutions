select distinct p1.user_id as user_id
from purchases p1
left join purchases p2
on p1.user_id = p2.user_id
where p1.purchase_id != p2.purchase_id 
and abs(datediff(p1.purchase_date, p2.purchase_date)) <= 7
order by p1.user_id asc