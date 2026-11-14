

CREATE PROCEDURE UnpivotProducts()
BEGIN
    SET SESSION group_concat_max_len = 1000000;

    SELECT GROUP_CONCAT(
        CONCAT(
            'SELECT product_id, ''', column_name, ''' AS store, ',
            column_name, ' AS price FROM Products WHERE ',
            column_name, ' IS NOT NULL '
        ) SEPARATOR ' UNION ALL '
    ) INTO @query
    FROM information_schema.columns
    WHERE table_name = 'Products'
      AND column_name <> 'product_id';

    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END  ;
