select
    count(*) as fish_count
from fish_info
where length <= 10.0 or length is null;