SELECT
    p.product_code,
    sum(p.price * o.sales_amount) as 매출액
from product p
join offline_sale o
on p.product_id = o.product_id
group by p.product_code
order by 매출액 desc, p.product_code asc;