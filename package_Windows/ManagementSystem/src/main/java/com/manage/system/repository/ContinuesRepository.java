package com.manage.system.repository;

public interface ContinuesRepository {
	
	Long countByCreatedAtCon(String createdAt);
	
	Long sumAmountByCreatedAtAndCashCon(String createdAt);
	
	Long sumAmountByCreatedAtAndCreditCon(String createdAt);

}
