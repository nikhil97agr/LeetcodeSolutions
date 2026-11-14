select
concat(t1.topping_name,',', t2.topping_name,',', t3.topping_name) as pizza,
t1.cost + t2.cost + t3.cost as total_cost
from toppings t1
join toppings t2
on t1.topping_name <> t2.topping_name and strcmp(t1.topping_name, t2.topping_name) < 0
join toppings t3
on t1.topping_name <> t3.topping_name and t2.topping_name <> t3.topping_name and strcmp(t2.topping_name , t3.topping_name) < 0
order by total_cost desc, pizza asc