package com.uap.service;

import java.util.List;

import com.uap.model.RelationEntity;

public interface RelationService {

	/**
	 * 通过userId得到关系List
	 * @param userId
	 * @return
	 */
	List<RelationEntity> getRelationByUserId(int userId);

	/**
	 * 批量插入关系数据
	 * @param relationList
	 */
	void insertRelations(List<RelationEntity> relationList);

	
}
