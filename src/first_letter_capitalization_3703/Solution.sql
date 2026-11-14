WITH RECURSIVE cte AS (
    SELECT
        content_id,
        content_text,
        1 AS pos,
        CAST(
            CASE
                WHEN SUBSTRING(content_text, 1, 1) = ' '
                THEN ' '
                ELSE UPPER(SUBSTRING(content_text, 1, 1))
            END
            AS CHAR(10000)
        ) AS result
    FROM user_content

    UNION ALL

    SELECT
        cte.content_id,
        cte.content_text,
        cte.pos + 1,
        CONCAT(
            cte.result,
            CASE
                WHEN SUBSTRING(cte.content_text, cte.pos + 1, 1) = ' '
                THEN ' '
                WHEN SUBSTRING(cte.content_text, cte.pos, 1) = ' '
                THEN UPPER(SUBSTRING(cte.content_text, cte.pos + 1, 1))
                ELSE LOWER(SUBSTRING(cte.content_text, cte.pos + 1, 1))
            END
        ) AS result
    FROM cte
    WHERE cte.pos < CHAR_LENGTH(cte.content_text)
)
SELECT
    content_id,
    content_text as original_text,
    result AS converted_text
FROM cte
WHERE pos = CHAR_LENGTH(content_text)
order by content_id
