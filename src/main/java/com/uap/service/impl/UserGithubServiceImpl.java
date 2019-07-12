package com.uap.service.impl;

import com.uap.dao.UserGithubDao;
import com.uap.model.UserGithubEntity;
import com.uap.service.UserGithubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGithubServiceImpl implements UserGithubService {

	@Autowired
	private UserGithubDao userGithubDao;

	@Override
	public void insertEntity(UserGithubEntity userGithubEntity) {
		userGithubDao.insertEntity(userGithubEntity);
	}
}
