SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, '%Y-%m-%d') as created_date
  FROM used_goods_board b, used_goods_reply r
 WHERE r.board_id = b.board_id AND DATE_FORMAT(b.created_date, '%Y-%m') = '2022-10'
 ORDER BY r.created_date ASC, b.title ASC;