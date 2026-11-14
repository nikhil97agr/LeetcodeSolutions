with sales_person as (
    select s.salesperson_id, c.customer_id, name
    from salesperson s
    left join customer c
    on s.salesperson_id =c.salesperson_id

)

select s1.salesperson_id, name, ifnull(sum(price), 0) as total
from sales_person s1
left join sales s2
on s1.customer_id = s2.customer_id
group by s1.salesperson_id