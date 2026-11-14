with session as (
    select book_id, round((sum(case when session_rating <= 2 or session_rating >= 4 then 1 else 0 end))/(count(*)),2) as polarization_score, max(session_rating) - min(session_rating) as rating_spread
    from reading_sessions r
    group by book_id
    having polarization_score >= 0.6 and count(*) >= 5 and max(session_rating)>=4 and min(session_rating) <= 2
)

select b.book_id, b.title, author, genre, pages, rating_spread, polarization_score
from session s
left join books b
on b.book_id = s.book_id
order by polarization_score desc, title desc
