package com.uap.service.impl;

import java.util.List;

import com.uap.dao.PostCardDao;
import com.uap.dao.ReplyCardDao;
import com.uap.model.PostCardEntity;
import com.uap.model.view.PostCardModel;
import com.uap.service.PostCardService;
import com.uap.utils.DateUtil;
import com.uap.utils.SecurityAuthenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostCardServiceImpl implements PostCardService {

	@Autowired
	private PostCardDao postCardDao;
	
	@Autowired
	private ReplyCardDao replyCardDao;

	@Override
	public List<PostCardModel> postcardList(String interestid, int pageSize, int start) {
		return postCardDao.postcardList(interestid,pageSize,start);
	}

	@Override
	public Integer postcardSize(String interestid, int pageSize, int start) {
		return postCardDao.postcardSize(interestid,pageSize,start);
	}

	@Override
	public void insertEntity(PostCardEntity postCardEntity) {
		int userid = SecurityAuthenUtil.getId();

//		postCardEntity.setUsername(SecurityAuthenUtil.getLoginName());
		postCardEntity.setUserid(userid);
		postCardEntity.setCreatetime(DateUtil.currentTimestamp());
		postCardEntity.setReplytime(postCardEntity.getCreatetime());
		postCardDao.insertEntity(postCardEntity);
	}

	@Override
	public PostCardModel getPostcard(int id) {
		return postCardDao.getPostcard(id);
	}

	@Override
	@Transactional
	public void deletePostcards(List<String> groupId) {
		postCardDao.deletePostcards(groupId);
		replyCardDao.delReplyByPostcardid(groupId);
	}


}
