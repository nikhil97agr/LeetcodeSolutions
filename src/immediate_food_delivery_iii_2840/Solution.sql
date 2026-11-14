with cte as (select order_date, 
case 
    when order_date = customer_pref_delivery_date then 'immediate'
    else 'scheduled'
end as type
from delivery)


select order_date,
 round((100*sum(if(type='immediate', 1, 0))/(count(*))),2) as immediate_percentage
from cte
group by order_date
order by order_date asc