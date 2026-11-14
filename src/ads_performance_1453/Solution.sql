with clicked as (
    select ad_id, sum(case when action='Clicked' then 1 else 0 end) as click
    from ads
    group by ad_id
),
viewed as (
    select ad_id, sum(case when action='Viewed' then 1 else 0 end) as view
    from ads
    group by ad_id
)


select c.ad_id, case when (click + view) = 0 then 0 else round((click/(view + click))*100,2) end as ctr
from clicked c
join viewed v
on c.ad_id = v.ad_id
order by ctr desc, c.ad_id asc