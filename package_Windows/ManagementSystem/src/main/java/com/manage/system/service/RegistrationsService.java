package com.manage.system.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.system.repository.RegistrationsRepository;

/**
 * @概要: RegistrationsRepositoryでDB処理をServiceとして処理する。
 * @処理内容: RegistrationsRepositoryを戻り値にする。
 */

@Service
public class RegistrationsService {
	
	private final RegistrationsRepository registrationsRepository;
	
	public RegistrationsService(RegistrationsRepository registrationsRepository) {
		this.registrationsRepository = registrationsRepository;
	}
	
	@Transactional
	public Long countCreatedAt() {
		return registrationsRepository.countCreatedAt();
	}
	
	@Transactional
	public List<Timestamp> createdAtList(){
		return registrationsRepository.createdAtList();
	}

	@Transactional
	public Long countByCreatedAtRes(String createdAt){
        return registrationsRepository.countByCreatedAtRes(createdAt);

    }
	
	@Transactional
	public Long countByCreatedAtAndInvCodeRes(String createdAt){
        return registrationsRepository.countByCreatedAtAndInvCodeRes(createdAt);

    }
	
	@Transactional
	public Long sumAmountByCreatedAtAndCashRes(String createdAt){
        return registrationsRepository.sumAmountByCreatedAtAndCashRes(createdAt);

    }
	
	public Long sumAmountByCreatedAtAndCreditRes(String createdAt) {
		return registrationsRepository.sumAmountByCreatedAtAndCreditRes(createdAt);
	}
}
