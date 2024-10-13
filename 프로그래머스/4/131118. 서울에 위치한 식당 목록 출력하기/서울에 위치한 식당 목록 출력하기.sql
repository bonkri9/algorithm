SELECT
    ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address,
    round(avg(rr.review_score), 2) as score
from rest_info ri, rest_review rr
where
    ri.rest_id = rr.rest_id
    and
    ri.address like '서울%'
group by ri.rest_id 
order by score desc, ri.favorites desc;


# select * 
# from rest_info ri
# left outer join rest_review rr
# on ri.rest_id = rr.rest_id
# where 
#     ri.address like '%서울%';