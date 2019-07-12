package com.uap.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.uap.model.InterestEntity;

public interface InterestService {

	List<InterestEntity> getInsterest(String title);

	InterestEntity getInsterestById(int id);

    String savePicture(MultipartFile picture);

	void insertEntity(InterestEntity interestEntity);

	void updateEntity(InterestEntity interestEntity);

	List<InterestEntity> interestList(int pageSize, int start);

	Integer interestSize();

	void deleteInterests(List<String> groupId);

    List<InterestEntity> getBanners();

	void updateBanners(List<String> groupId, int i);
}
