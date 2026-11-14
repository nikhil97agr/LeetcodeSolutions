with recursive dates as (
    select '2023-11-03' as curr_date,
    1 as week
    
    union all
    select
    date_add(curr_date, interval 7 day) as curr_date,
    week+1
    from dates
    where date_add(curr_date, interval 7 day) <= '2023-11-30'
),
pairs as (
    select 'Premium' as membership
    union 
    select 'VIP' as membership
),
t1 as (
    select 
    membership,
    curr_date,
    week
    from pairs, dates
),
t2 as (
    select
membership,
purchase_date,
sum(amount_spend) as total_amount
from purchases p
join users u
on p.user_id = u.user_id
where membership <> 'Standard'
group by purchase_date, membership

)

-- select * from t1

select
week as week_of_month,
t1.membership,
ifnull(total_amount, 0) as total_amount
from t1
left join t2
on t1.membership = t2.membership
and t1.curr_date = t2.purchase_date
group by week,  t1.membership
order by week_of_month , t1.membership


