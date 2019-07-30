package com.manage.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.system.repository.ContinueGoodsRepository;

/**
 * @概要: ContinueGoodsRepositoryでDB処理をServiceとして処理する。
 * @処理内容: ContinueGoodsRepositoryを戻り値にする。
 */

@Service
public class ContinueGoodsService {
	
	private final ContinueGoodsRepository continueGoodsRepository;
	
	public ContinueGoodsService(ContinueGoodsRepository continueGoodsRepository) {
		this.continueGoodsRepository = continueGoodsRepository;
	}
	
	@Transactional
	public Long countByCreatedAtConGoods(String createdAt) {
		return continueGoodsRepository.countByCreatedAtConGoods(createdAt);

	}

}
