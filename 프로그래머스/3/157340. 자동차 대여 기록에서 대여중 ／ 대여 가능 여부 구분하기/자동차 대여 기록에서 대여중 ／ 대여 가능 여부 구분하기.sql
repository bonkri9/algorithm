SELECT
    car_id,
    if(
        max(
            case when '2022-10-16' between start_date and end_date 
                then 1 
                else null 
            end
        ) is not null,
        '대여중',
        '대여 가능'
    ) as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc;