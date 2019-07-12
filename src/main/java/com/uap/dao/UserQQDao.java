package com.uap.dao;

import org.apache.ibatis.annotations.Mapper;

import com.uap.model.UserQQEntity;

@Mapper
public interface UserQQDao {

	void insertEntity(UserQQEntity userQQEntity);
}
