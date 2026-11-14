select max(c2.visited_on) as visited_on , sum(c2.amount) as amount, round(sum(c2.amount)/7,2) as average_amount

from (select distinct(visited_on) from customer) c1
left join customer c2
on c2.visited_on between c1.visited_on and date_add(c1.visited_on, interval 6 day)
and date_add(c1.visited_on, interval 6 day) <= (select max(visited_on) from customer)
where c2.visited_on is not null
group by c1.visited_on
order by c1.visited_on asc
