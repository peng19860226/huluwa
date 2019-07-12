package com.uap.service;

import java.util.List;

import com.uap.model.PostCardEntity;
import com.uap.model.view.PostCardModel;

public interface PostCardService {

	List<PostCardModel> postcardList(String interestid, int pageSize, int start);

	Integer postcardSize(String interestid, int pageSize, int start);

	void insertEntity(PostCardEntity postCardEntity);

	PostCardModel getPostcard(int id);

	void deletePostcards(List<String> groupId);

}
