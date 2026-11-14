
select player_id, player_name, sum(grand_slams_count) as grand_slams_count

from (select p.player_id, player_name, count(*) as grand_slams_count
from players p
join championships c
on p.player_id = wimbledon
group by p.player_id

union all

select p.player_id, player_name, count(*) as grand_slams_count
from players p
join championships c
on p.player_id = fr_open
group by p.player_id

union all 

select p.player_id, player_name, count(*) as grand_slams_count
from players p
join championships c
on p.player_id = us_open
group by p.player_id

union all

select p.player_id, player_name, count(*) as grand_slams_count
from players p
join championships c
on p.player_id = au_open
group by p.player_id) data 
group by player_id