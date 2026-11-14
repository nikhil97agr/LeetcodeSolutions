with season as (select month(sale_date) as months,
case when month(sale_date) >= 3 and month(sale_date) <= 5 then 'Spring'
when month(sale_date) >= 6 and month(sale_date) <=8 then 'Summer'
when month(sale_date) >= 9 and month(sale_date) <= 11 then 'Fall'
else 'Winter' end
as season
from sales
group by month(sale_date)),

category_data as

(
    select 
se.season, 
p.category, 
sum(s.quantity) as total_quantity, 
sum(s.quantity * s.price) as total_revenue

from products p
join sales s
on p.product_id = s.product_id
join season se
on month(s.sale_date) = se.months
group by se.season, p.category
order by total_quantity desc, total_revenue desc
),

ranked_data as (
    select season, category, total_quantity, total_revenue,
rank() over(partition by season order by total_quantity desc, total_revenue desc) as ranks
    from category_data
)

select season, category, total_quantity, total_revenue
from ranked_data
where ranks = 1
