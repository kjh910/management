package com.manage.system.repository;

import static com.manage.system.util.DateTimeUtils.dateTimeOf;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.manage.system.entity.RegistrationsEntity;


/**
 * @概要: DBでの処理の Registrationsテーブル関連の 数値演算を処理
 * @処理内容: SQL文転送 -> 各型式に合わせて結果を戻す。
 */
@Repository
public class JdbcRegistrationsRepository implements RegistrationsRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcRegistrationsRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public Long countCreatedAt() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "
					+ "FROM "
						+ "(SELECT DATE(created_at) "
							+ "FROM registrations "
							+ "GROUP BY DATE(created_at) "
							+ "ORDER BY DATE(created_at) DESC) "
					+ "AS foo;",Long.class);
	}
	
	@Override
	public List<Timestamp> createdAtList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList(
				"SELECT * "
					+ "FROM "
						+ "(SELECT DATE(created_at) "
							+ "FROM registrations "
							+ "GROUP BY DATE(created_at) "
							+ "ORDER BY DATE(created_at) DESC) "
					+ "AS foo;",Timestamp.class);
	}
	
	@Override
	public Long countByCreatedAtRes(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "
					+ "FROM registrations "
					+ "WHERE created_at LIKE ?", new Object[] {createdAt+"%"},
				Long.class);
	}
	
	@Override
	public Long countByCreatedAtAndInvCodeRes(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "
					+ "FROM registrations "
					+ "WHERE created_at LIKE ? "
					+ "AND invitation_code IS NOT NULL", new Object[] {createdAt+"%"},
				Long.class);
	}
	
	@Override
	public Long sumAmountByCreatedAtAndCashRes(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT sum(amount) "
					+ "FROM registrations "
					+ "WHERE created_at LIKE ? "
					+ "AND payment_way ='HANDING_CASH'", new Object[] {createdAt+"%"},
				Long.class);
	}
	
	@Override
	public Long sumAmountByCreatedAtAndCreditRes(String createdAt) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT sum(amount) "
					+ "FROM registrations "
					+ "WHERE created_at LIKE ? "
					+ "AND payment_way ='HANDING_CREDIT_CARD'", new Object[] {createdAt+"%"},
				Long.class);
	}

	static RowMapper<RegistrationsEntity> mapper = (rs, rowNum) -> new RegistrationsEntity(
			rs.getLong("id"),
			rs.getString("receiptNumber"),
			rs.getString("phoneMobile"),
			rs.getString("paymentWay"),
			rs.getLong("amount"),
			rs.getInt("refund"),
			rs.getString("deviceId"),
			rs.getInt("specialGoodFlag"),
			dateTimeOf(rs.getTimestamp("createAt")),
			dateTimeOf(rs.getTimestamp("updateAt")));
	
}
