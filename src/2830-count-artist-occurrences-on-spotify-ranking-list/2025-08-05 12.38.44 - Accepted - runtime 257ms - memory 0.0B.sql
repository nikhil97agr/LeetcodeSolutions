select artist, count(*) as occurrences
from spotify
group by artist
order by occurrences desc, artist asc