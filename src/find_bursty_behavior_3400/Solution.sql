WITH daily_posts AS (
    SELECT
        user_id,
        post_date,
        COUNT(*) AS daily_cnt
    FROM posts
    WHERE post_date BETWEEN '2024-02-01' AND '2024-02-28'
    GROUP BY user_id, post_date
),
rolling_7day AS (
    SELECT
        user_id,
        post_date,
        SUM(daily_cnt) OVER (
            PARTITION BY user_id
            ORDER BY post_date
            RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW
        ) AS posts_7day
    FROM daily_posts
),
max_7day AS (
    SELECT
        user_id,
        MAX(posts_7day) AS max_7day_posts
    FROM rolling_7day
    GROUP BY user_id
),
avg_weekly AS (
    SELECT
        user_id,
        COUNT(*) / 4.0 AS avg_weekly_posts
    FROM posts
    WHERE post_date BETWEEN '2024-02-01' AND '2024-02-28'
    GROUP BY user_id
)

SELECT
    m.user_id,
    m.max_7day_posts,
    a.avg_weekly_posts
FROM max_7day m
JOIN avg_weekly a
  ON m.user_id = a.user_id
WHERE m.max_7day_posts >= 2 * a.avg_weekly_posts
ORDER BY m.user_id;
