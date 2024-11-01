SELECT
    hour(datetime) as hour,
    count(*) as count
from animal_outs
where hour(datetime) between 9 and 19
group by 1
order by 1;