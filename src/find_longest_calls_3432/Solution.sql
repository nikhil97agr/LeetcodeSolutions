with outgoing as (
        select
first_name,
type,
duration
from calls c1
join contacts c2
on c1.contact_id = c2.id

where type = 'outgoing'
order by duration desc, first_name desc
limit 3
),
incoming as (
    select
first_name,
type,
duration
from calls c1
join contacts c2
on c1.contact_id = c2.id
where type = 'incoming'
order by duration desc, first_name desc
limit 3
),
cte as (
    select * from outgoing
    union all
    select * from incoming
)

select 
first_name,
type,
CONCAT(
    LPAD(FLOOR(duration / 3600), 2, '0'), ':',
    LPAD(FLOOR((duration % 3600) / 60), 2, '0'), ':',
    LPAD(duration % 60, 2, '0')
  ) as duration_formatted
from cte