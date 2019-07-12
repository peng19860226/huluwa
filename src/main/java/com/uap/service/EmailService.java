package com.uap.service;

import java.util.List;

import com.uap.model.EmailEntity;

public interface EmailService {

	void insertEntity(EmailEntity emailEntity);

	List<EmailEntity> emailsList(int pageSize, int start);

	Integer emailsSize(int pageSize, int start);

    void deleteEmails(List<String> groupId);
}
