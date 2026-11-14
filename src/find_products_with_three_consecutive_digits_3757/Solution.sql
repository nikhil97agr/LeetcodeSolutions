select product_id, name
from products
where name regexp "[0-9]{3}"
and name not regexp "[0-9]{4}"
order by product_id