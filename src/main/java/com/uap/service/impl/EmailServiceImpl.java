package com.uap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uap.dao.EmailDao;
import com.uap.model.EmailEntity;
import com.uap.service.EmailService;
import com.uap.utils.DateUtil;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;

	@Override
	public void insertEntity(EmailEntity emailEntity) {
		emailEntity.setCreatetime(DateUtil.currentTimestamp());
		emailDao.insertEntity(emailEntity);
	}

	@Override
	public List<EmailEntity> emailsList(int pageSize, int start) {
		return emailDao.emailsList(pageSize,start);
	}

	@Override
	public Integer emailsSize(int pageSize, int start) {
		return emailDao.emailsSize(pageSize,start);
	}

	@Override
	public void deleteEmails(List<String> groupId) {
		emailDao.deleteEmails(groupId);
	}


}
