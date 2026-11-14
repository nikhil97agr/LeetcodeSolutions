select distinct(title)
from TVProgram t
join content c
on c.content_id = t.content_id
where YEAR(program_date) = 2020 and MONTH(program_date) = 6 
and content_type = 'Movies'
and kids_content = 'Y'
