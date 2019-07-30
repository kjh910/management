package com.manage.system.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @概要: DBでの処理の continuesテーブル関連の数値演算を処理
 * @処理内容: SQL文転送 -> 各型式に合わせて結果を戻す。
 */

@Repository
public class JdbcContinuesRepository implements ContinuesRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcContinuesRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Long countByCreatedAtCon(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
						"SELECT count(*) "
							+ "FROM continues "
							+ "WHERE created_at LIKE ?", new Object[] {createdAt+"%"},
						Long.class);
	}

	@Override
	public Long sumAmountByCreatedAtAndCashCon(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT sum(amount) "
					+ "FROM continues "
					+ "WHERE created_at LIKE ? "
					+ "AND payment_way ='HANDING_CASH'", new Object[] {createdAt+"%"},
				Long.class);
	}

	@Override
	public Long sumAmountByCreatedAtAndCreditCon(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT sum(amount) "
					+ "FROM continues "
					+ "WHERE created_at LIKE ? "
					+ "AND payment_way ='HANDING_CREDIT_CARD'", new Object[] {createdAt+"%"},
				Long.class);
	}

}
