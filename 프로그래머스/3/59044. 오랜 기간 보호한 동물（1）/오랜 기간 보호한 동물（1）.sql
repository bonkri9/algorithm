select
    name,
    datetime
from animal_ins i
where 
    i.animal_id
    not in
    (
        select animal_id
        from animal_outs
    )
order by i.datetime asc
limit 3;


# SELECT
#     i.name,
#     i.datetime
# from animal_ins i
# left join animal_outs o 
# on i.animal_id = o.animal_id
# where
#     o.animal_id is null
# order by i.datetime asc
# limit 3;