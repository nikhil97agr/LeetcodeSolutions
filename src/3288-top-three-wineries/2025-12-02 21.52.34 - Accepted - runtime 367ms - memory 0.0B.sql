with cte as (
    select
country,
sum(points) as points,
winery
from wineries
group by country, winery
),
 cte2 as (

select 
country,
points,
winery,
row_number() over(partition by country order by points desc, winery asc) as ranks
from cte
)


select
c1.country,
concat(c1.winery,' (',c1.points,')') as top_winery,
if(c2.winery is null, 'No second winery', concat(c2.winery,' (',c2.points,')')) as second_winery,
if(c3.winery is null, 'No third winery', concat(c3.winery,' (',c3.points,')')) as third_winery
from cte2 c1
left join cte2 c2
on c1.country = c2.country and c2.ranks = 2
left join cte2 c3
on c1.country = c3.country and c3.ranks = 3
where c1.ranks = 1