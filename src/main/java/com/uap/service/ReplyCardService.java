package com.uap.service;

import java.util.List;

import com.uap.model.ReplyCardEntity;
import com.uap.model.view.ReplyCardModel;

public interface ReplyCardService {

	List<ReplyCardModel> replycardList(int postcardid, int pageSize, int start);

	Integer replycardSize(int postcardid, int pageSize, int start);

	void insertEntity(ReplyCardEntity replyCardEntity);

}
