with data as (
    select order_id,
        avg(quantity) as average,
        max(quantity) as maximum
    from ordersdetails
    group by order_id
)

select order_id from data 
where maximum > (select max(average) from data)