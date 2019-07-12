package com.uap.service.impl;

import com.uap.dao.MsgRecordsDao;
import com.uap.model.MsgRecordEntity;
import com.uap.model.PageResult;
import com.uap.model.view.MsgRecordModel;
import com.uap.service.MsgRecordsService;
import com.uap.utils.SecurityAuthenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Override
    public boolean addMsg(MsgRecordEntity entity) {
        msgRecordsDao.addMsg(entity);
        return false;
    }

    @Override
    public int getUnreadMsgCount(Integer userid) {
        return msgRecordsDao.getUnreadMsgCount(userid);
    }

    @Override
    @Transactional
    public PageResult getUserMegsResult(int pageSize, int start) {
        int userid = SecurityAuthenUtil.getId();
        List<MsgRecordModel> list = msgRecordsDao.getMsgListByUserid(userid,pageSize,start);
        int size = msgRecordsDao.getMsgSizeByUserid(userid);

        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(size);
        pageResult.setData(list);
        return pageResult;
    }

    @Override
    public void updateMsgRecordIsread(Integer msgRecordId, int isread) {
        msgRecordsDao.updateMsgRecordIsread(msgRecordId,isread);
    }
}
