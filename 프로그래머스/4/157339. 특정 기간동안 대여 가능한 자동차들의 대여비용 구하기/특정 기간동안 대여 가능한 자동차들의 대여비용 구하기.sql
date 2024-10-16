select
    c.car_id,
    c.car_type,
    round(c.daily_fee * 30 * (100 - cast(replace(discount_rate, '%', '') as unsigned)) / 100, 0) as fee
from car_rental_company_car c
join (
    select
        car_id,
        count(case when start_date > '2022-11-30' or end_date < '2022-11-01' then null else 1 end) as tmp
    from car_rental_company_rental_history
    group by car_id
    having tmp = 0
    ) h on c.car_id = h.car_id
join (
    select *
    from car_rental_company_discount_plan
    where duration_type = '30일 이상'
    ) p on c.car_type = p.car_type
having fee >= 500000 and fee <= 2000000
order by 3 desc, 2, 1 desc;
