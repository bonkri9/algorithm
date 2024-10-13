select
    *
from food_product
where price = (
    SELECT
        max(price)
    from food_product
);
