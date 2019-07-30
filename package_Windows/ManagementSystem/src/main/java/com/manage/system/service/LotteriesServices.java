package com.manage.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.system.repository.LotteriesRepository;

/**
 * @概要: LotteriesRepositoryでDB処理をServiceとして処理する。
 * @処理内容: LotteriesRepositoryを戻り値にする。
 */

@Service
public class LotteriesServices {

	private final LotteriesRepository lotteriesRepository;
	
	public LotteriesServices(LotteriesRepository lotteriesRepository) {
		this.lotteriesRepository = lotteriesRepository;
	}
	
	@Transactional
	public Long countByCreatedAtLotteries(String createdAt){
        return lotteriesRepository.countByCreatedAtLotteries(createdAt);

    }
}
