select name, sum(amount) as balance
from users
left join transactions t
on users.account = t.account
group by t.account
having balance > 10000;