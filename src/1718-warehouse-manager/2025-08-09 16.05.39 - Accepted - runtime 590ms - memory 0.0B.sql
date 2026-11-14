select name as warehouse_name, sum(p.width*p.height*p.length*w.units) as volume

from warehouse w
join products p
on w.product_id = p.product_id
group by name
