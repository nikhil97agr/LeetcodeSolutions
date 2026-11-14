select name as Customers
from customers
left join
orders
on customers.id = customerId
where customerId is null