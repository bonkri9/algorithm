select
    year(differentiation_date) as year,
    max(size_of_colony) over(partition by year(differentiation_date)) - size_of_colony as year_dev,
    id
from ecoli_data
order by year asc, year_dev asc;