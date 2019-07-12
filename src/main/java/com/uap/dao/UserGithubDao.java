package com.uap.dao;

import org.apache.ibatis.annotations.Mapper;

import com.uap.model.UserGithubEntity;

@Mapper
public interface UserGithubDao {

	void insertEntity(UserGithubEntity userGithubEntity);
}
