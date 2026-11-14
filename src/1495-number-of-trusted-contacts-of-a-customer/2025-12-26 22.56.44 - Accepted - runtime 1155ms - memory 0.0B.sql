with trusted_contacts as (
    select
    c1.customer_id, 
    c1.customer_name,
    count(*) as trusted_contacts_cnt
    from customers c1
    left join contacts c2
    on c1.customer_id = c2.user_id
    join customers c3
    on c3.email = c2.contact_email
    group by c1.customer_id
),
invoice as (
    select
    invoice_id,
    i.user_id,
    price,
    c.customer_name
    from invoices i
    left join customers c
    on i.user_id = c.customer_id

),
contact as (
    select 
    i.invoice_id,
    i.user_id,
    price, 
    count(c.user_id) as contacts_cnt,
    i.customer_name
    from invoice i
    left join contacts c
    on i.user_id = c.user_id
    group by i.invoice_id, i.user_id
)


select 
c1.invoice_id,
c1.customer_name,
c1.price,
c1.contacts_cnt,
ifnull(c2.trusted_contacts_cnt, 0) as trusted_contacts_cnt
from contact c1
left join trusted_contacts c2
on c1.user_id = c2.customer_id
group by invoice_id
order by invoice_id
