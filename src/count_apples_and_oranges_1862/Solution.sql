select sum(ifnull(b.apple_count, 0) + ifnull(c.apple_count,0)) as apple_count, sum(ifnull(b.orange_count,0) + ifnull(c.orange_count, 0)) as orange_count
from boxes b
left join chests c
on b.chest_id = c.chest_id