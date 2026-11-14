# Write your MySQL query statement below
select c.class

from ( select class, count(class) as total from courses group by class ) c

where c.total >= 5;