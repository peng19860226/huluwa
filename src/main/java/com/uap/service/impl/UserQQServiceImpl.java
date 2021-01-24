package com.uap.service.impl;

import com.uap.dao.UserQQDao;
import com.uap.model.UserQQEntity;
import com.uap.service.UserQQService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQQServiceImpl implements UserQQService {

	@Autowired
	private UserQQDao userQQDao;

	@Override
	public void insertEntity(UserQQEntity userQQEntity) {
		userQQDao.insertEntity(userQQEntity);
	}
}
