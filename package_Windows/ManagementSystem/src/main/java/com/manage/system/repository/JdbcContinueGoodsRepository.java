package com.manage.system.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @概要: DBでの処理の continue_goodsテーブル関連の数値演算を処理
 * @処理内容: SQL文転送 -> 各型式に合わせて結果を戻す。
 */

@Repository
public class JdbcContinueGoodsRepository implements ContinueGoodsRepository{
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcContinueGoodsRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Long countByCreatedAtConGoods(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "
					+ "FROM continue_goods "
					+ "WHERE created_at LIKE ?", new Object[] {createdAt+"%"},
				Long.class);
	}

}
