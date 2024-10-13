select
    count(*) as fish_count
from fish_info i, fish_name_info n
where
    i.fish_type = n.fish_type
    and
    n.fish_name in ('BASS', 'SNAPPER');