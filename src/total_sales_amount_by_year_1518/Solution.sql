with recursive cte as (
    select 
    product_id,
    period_start,
    period_end,
    average_daily_sales
    from sales

    union all

    select
    product_id,
    date_add(period_start, interval 1 day) as period_start,
    period_end,
    average_daily_sales
    from cte
    where period_start < period_end
),
cte2 as (
    select
product_id,
year(period_start) as report_year,
sum(average_daily_sales) as total_amount
from cte
group by product_id, report_year
)


select
p.product_id,
product_name,
cast(report_year as char) as report_year,
total_amount
from cte2 c
join product p
on p.product_id = c.product_id
order by p.product_id, report_year