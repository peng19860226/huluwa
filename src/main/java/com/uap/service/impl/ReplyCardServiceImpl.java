package com.uap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.uap.dao.PostCardDao;
import com.uap.dao.ReplyCardDao;
import com.uap.model.MsgRecordEntity;
import com.uap.model.ReplyCardEntity;
import com.uap.model.view.ReplyCardModel;
import com.uap.service.MsgRecordsService;
import com.uap.service.ReplyCardService;
import com.uap.utils.DateUtil;
import com.uap.utils.SecurityAuthenUtil;

@Service
public class ReplyCardServiceImpl implements ReplyCardService {

	@Autowired
	private ReplyCardDao replyCardDao;
	
	@Autowired
	private PostCardDao postCardDao;

	@Autowired
	private MsgRecordsService msgRecordsService;

	@Override
	public List<ReplyCardModel> replycardList(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardList(postcardid,pageSize,start);
	}

	@Override
	public Integer replycardSize(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardSize(postcardid,pageSize,start);
	}

	@Override
	public void insertEntity(ReplyCardEntity replyCardEntity) {

		//User user = SecurityAuthenUtil.getAuthenticationUser();
		//replyCardEntity.setUsername(user.getUsername());
		//replyCardEntity.setUserid(user.);

		int userid = SecurityAuthenUtil.getId();

		replyCardEntity.setUserid(userid);

		replyCardEntity.setCreatetime(DateUtil.currentTimestamp());
		
		postCardDao.updateCreatetiem(replyCardEntity.getPostcardid(),replyCardEntity.getCreatetime());
		replyCardDao.insertEntity(replyCardEntity);


		MsgRecordEntity msgRecordEntity = new MsgRecordEntity();
		msgRecordEntity.setReplyid(replyCardEntity.getId());

		Integer cardId = replyCardEntity.getPostcardid();
		msgRecordEntity.setCardid(cardId);

		msgRecordEntity.setOwnerid(postCardDao.getPostcard(cardId).getUserid());
		msgRecordEntity.setIsread(0);
		msgRecordEntity.setReplytime(DateUtil.currentTimestamp());

		msgRecordsService.addMsg(msgRecordEntity);

	}
	
//	@Override
//	public List<PostCardEntity> postcardList(int interestid, int pageSize, int start) {
//		return replyCardDao.postcardList(interestid,pageSize,start);
//	}
//
//	@Override
//	public Integer postcardSize(int interestid, int pageSize, int start) {
//		return replyCardDao.postcardSize(interestid,pageSize,start);
//	}

//
//	@Override
//	public PostCardEntity getPostcard(int id) {
//		return replyCardDao.getPostcard(id);
//	}

}
