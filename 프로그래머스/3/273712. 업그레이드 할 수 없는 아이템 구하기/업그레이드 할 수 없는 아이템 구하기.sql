select
    i.item_id,
    i.item_name,
    i.rarity
from item_info i
left outer join item_tree t
on i.item_id = t.parent_item_id   
where t.item_id is null
order by i.item_id desc;