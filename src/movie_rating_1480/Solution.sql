(select user.name as results from 
MovieRating as rating
join 
users as user
on user.user_id = rating.user_id
group by user.name
order by count(user.name) desc, user.name asc
LIMIT 1)
UNION ALL
(SELECT movie.title as results
FROM MOVIERATING rating
join MOVIES movie
on movie.movie_id = rating.movie_id
where extract(YEAR FROM rating.created_at) = 2020 and extract(MONTH from created_at) = 2
group by movie.title
order by avg(rating.rating) desc, movie.title asc
LIMIT 1);




