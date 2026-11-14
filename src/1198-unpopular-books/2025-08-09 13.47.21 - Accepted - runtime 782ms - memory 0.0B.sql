with filtered_books as (
    select book_id, name
    from books
    where available_From < date_add('2019-06-23', interval -1 month)
)

select b.book_id, name
from filtered_books b
left join orders o
on b.book_id = o.book_id
and dispatch_date <= '2019-06-23' and dispatch_date >= date_add('2019-06-23', interval -1 year)
group by b.book_id
having ifnull(sum(quantity), 0) <10