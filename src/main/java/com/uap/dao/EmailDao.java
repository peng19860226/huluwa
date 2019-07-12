package com.uap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.uap.model.EmailEntity;

@Mapper
public interface EmailDao {

	void insertEntity(EmailEntity emailEntity);

	List<EmailEntity> emailsList(@Param("pageSize") int pageSize, @Param("start") int start);

	Integer emailsSize(@Param("pageSize") int pageSize, @Param("start") int start);

    void deleteEmails(@Param("groupId") List<String> groupId);
}
