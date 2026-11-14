select trim(lower(product_name)) as product_name, 
concat(year(sale_date),'-',if(month(sale_date) >= 10, month(sale_date), concat('0',month(sale_date)))) as sale_date, count(sale_id) as total
from sales
group by trim(lower(product_name)), concat(year(sale_date),'-',if(month(sale_date) >= 10, month(sale_date), concat('0',month(sale_date))))
order by product_name asc, sale_date asc