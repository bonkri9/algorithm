select
    count(i.fish_type) as fish_count,
    n.fish_name
from fish_info i
join fish_name_info n
on i.fish_type = n.fish_type
group by n.fish_name
order by 1 desc;

