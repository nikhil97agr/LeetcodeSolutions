select s1.symbol as metal, s2.symbol as nonmetal
from elements s1
join elements s2
on s1.type = 'Metal' and s2.type = 'Nonmetal'