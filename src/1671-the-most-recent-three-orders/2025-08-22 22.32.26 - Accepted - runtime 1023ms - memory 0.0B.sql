with ranked_data as (
    select name as customer_name, c.customer_id, o.order_Id, o.order_date, row_number() over(partition by o.customer_id order by o.order_date desc) as data_row
    from customers c
    join orders o
    on c.customer_id = o.customer_id
)


select customer_name, customer_id, order_id, order_date
from ranked_data
where data_row <=3
order by customer_name asc, customer_id asc, order_date desc