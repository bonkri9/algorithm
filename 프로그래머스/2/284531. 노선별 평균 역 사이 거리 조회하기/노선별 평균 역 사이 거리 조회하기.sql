select
    route,
    concat(round(sum(D_BETWEEN_DIST), 1), 'km') as total_distance,
    concat(round(avg(D_BETWEEN_DIST), 2), 'km') as average_distance
from subway_distance
group by route 
order by SUM(D_BETWEEN_DIST) desc;