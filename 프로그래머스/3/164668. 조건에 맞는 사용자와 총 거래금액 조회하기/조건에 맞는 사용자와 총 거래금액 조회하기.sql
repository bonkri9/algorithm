SELECT
    u.user_id,
    u.nickname,
    sum(price) as total_sales
from used_goods_board b
join used_goods_user u
on b.writer_id = u.user_id
where b.status = 'done'
group by u.user_id
having total_sales >= 700000
order by 3 asc;
