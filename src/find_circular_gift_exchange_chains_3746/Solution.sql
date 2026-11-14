with recursive cte as (
    select
    giver_id, receiver_id, 1 as chain_length,gift_value
    from secretsanta

    union all

    select
    c.giver_id,
    s.receiver_id,
    chain_length + 1,
    c.gift_value + s.gift_value as gift_value
    from cte c join secretsanta s
    on c.giver_id <> c.receiver_id and c.receiver_id = s.giver_id
)

select
rank() over(order by chain_length desc, gift_value desc) as chain_id,
chain_length,
gift_value as total_gift_value
from
(select distinct chain_length, gift_value from cte where receiver_id = giver_id ) t