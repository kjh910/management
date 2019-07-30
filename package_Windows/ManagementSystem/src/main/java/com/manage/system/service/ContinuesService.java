package com.manage.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.system.repository.ContinuesRepository;

/**
 * @概要: ContinuesRepositoryでDB処理をServiceとして処理する。
 * @処理内容: ContinuesRepositoryを戻り値にする。
 */


@Service
public class ContinuesService {

	private final ContinuesRepository continuesRepository;

	public ContinuesService(ContinuesRepository continuesRepository) {
		this.continuesRepository = continuesRepository;
	}

	@Transactional
	public Long countByCreatedAtCon(String createdAt) {
		return continuesRepository.countByCreatedAtCon(createdAt);

	}
	
	@Transactional
	public Long sumAmountByCreatedAtAndCashCon(String createdAt) {
		return continuesRepository.sumAmountByCreatedAtAndCashCon(createdAt);

	}
	
	@Transactional
	public Long sumAmountByCreatedAtAndCreditCon(String createdAt) {
		return continuesRepository.sumAmountByCreatedAtAndCreditCon(createdAt);

	}

}
