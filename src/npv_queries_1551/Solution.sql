select q.id, q.year, ifnull(npv, 0) as npv
from queries q
left join npv
on npv.id = q.id and npv.year = q.year
