WITH dedup AS (
    SELECT DISTINCT user_id, song_id, day
    FROM listens
),
matched AS (
    SELECT
        l1.user_id AS user1,
        l2.user_id AS user2,
        l1.day,
        l1.song_id
    FROM dedup l1
    JOIN dedup l2
        ON l1.song_id = l2.song_id
       AND l1.day = l2.day
       AND l1.user_id < l2.user_id
),
qualified AS (
    SELECT DISTINCT
        user1,
        user2
    FROM matched
    GROUP BY user1, user2, day
    HAVING COUNT(song_id) >= 3
)
SELECT
    q.user1 AS user_id,
    q.user2 AS recommended_id
FROM qualified q
LEFT JOIN friendship f
    ON (f.user1_id = q.user1 AND f.user2_id = q.user2)
    OR (f.user1_id = q.user2 AND f.user2_id = q.user1)
WHERE f.user1_id IS NULL

UNION ALL

SELECT
    q.user2 AS user_id,
    q.user1 AS recommended_id
FROM qualified q
LEFT JOIN friendship f
    ON (f.user1_id = q.user1 AND f.user2_id = q.user2)
    OR (f.user1_id = q.user2 AND f.user2_id = q.user1)
WHERE f.user1_id IS NULL;
