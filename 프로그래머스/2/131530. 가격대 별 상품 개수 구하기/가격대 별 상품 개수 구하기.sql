SELECT
    truncate(price, -4) as price_group,
    count(*)as products
from product 
group by price_group
order by price_group asc;
