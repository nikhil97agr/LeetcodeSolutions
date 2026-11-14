with ranks as (
    select contest_id,
 rank() over(order by contest_id asc) as id
 from contests
),
gold_medalists  as (
    select 
gold_medal as user_id
from contests
group by gold_medal
having count(contest_id) >= 3
),
medals as (
    select
contests.contest_id,
gold_medal as user_id,
id
from contests
join ranks
on ranks.contest_id = contests.contest_id
union
select 
contests.contest_id,
silver_medal as user_id,
id
from contests
join ranks
on ranks.contest_id = contests.contest_id
union
select
contests.contest_id,
bronze_medal as user_id,
id
from contests
join ranks
on ranks.contest_id = contests.contest_id

),
data as (
    select
m1.user_id
from medals m1
join medals m2
join medals m3
on m1.user_id= m2.user_id 
and m2.user_id = m3.user_id
and m2.id = m1.id + 1
and m2.id = m3.id - 1
group by m1.user_id
union
select 
distinct user_id
from gold_medalists


)

select
name,
mail
from users u
join data d
on u.user_id = d.user_id