

select s.user_id, sum(p.price*s.quantity) as spending
from Sales s
inner join Product p 
on p.product_id = s.product_id
group by s.user_id
order by spending desc
