package com.manage.system.repository;

import java.sql.Timestamp;
import java.util.List;

public interface RegistrationsRepository {
	
	Long countCreatedAt();
	
	List<Timestamp> createdAtList();
	
	Long countByCreatedAtRes(String createdAt);
	
	Long countByCreatedAtAndInvCodeRes(String createdAt);
	
	Long sumAmountByCreatedAtAndCashRes(String createdAt);
	
	Long sumAmountByCreatedAtAndCreditRes(String createdAt);
	
}
