select
    year(differentiation_date) as year,
    max(size_of_colony) over(partition by year(differentiation_date)) - size_of_colony as year_dev,
    id
from ecoli_data
order by year asc, year_dev asc;

# -------- join문 사용
# select
#     b.year,
#     maxyear - a.sizeofcolony as yeardev,
#     id
# from ecolidata a,
#     (
#     select 
#         year(differentiationdate) year, 
#         max(sizeofcolony) maxyear
#     from ecolidata
#     group by year
#     ) b
# where year(a.differentiationdate) = b.year
# order by b.year, yeardev;

# -------- correlated subquery 사용
# select 
#     year(differentiationdate) year,
#     (
#     select 
#         max(sizeofcolony) 
#     from ecolidata 
#     where year(differentiationdate) = year
#     ) - sizeofcolony as yeardev, 
#     id
# from ecolidata
# order by year, yeardev

# -------- with문 사용
# with maxcolony 
# as (
#     select 
#         max(sizeofcolony) maxcol, 
#         year(differentiationdate) year
#         from ecolidata 
#         group by year
#     )
# select 
#     m.year, 
#     maxcol - sizeofcolony as yeardev, 
#     id
# from ecolidata a, maxcolony m
# where year(a.differentiationdate) = m.year
# order by year, yeardev

# -------- 윈도우 함수 사용
# select
#     year(differentiation_date) as year,
#     max(size_of_colony) over(partition by year(differentiation_date)) - size_of_colony as year_dev,
#     id
# from ecoli_data
# order by year asc, year_dev asc;