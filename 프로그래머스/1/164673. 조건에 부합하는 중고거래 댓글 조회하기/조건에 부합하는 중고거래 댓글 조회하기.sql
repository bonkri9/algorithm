SELECT
    gb.title,
    gb.board_id,
    gr.reply_id,
    gr.writer_id,
    gr.contents,
    date_format(gr.created_date, '%Y-%m-%d') as created_date
from used_goods_board gb, used_goods_reply gr
where
    gb.board_id = gr.board_id
    and
    year(gb.created_date) = 2022
    and
    month(gb.created_date) = 10
order by gr.created_date asc, gb.title asc;
