package com.uap.service;

import com.uap.model.MsgRecordEntity;
import com.uap.model.PageResult;

public interface MsgRecordsService {

    /**
     * 添加消息记录
     * @param entity 消息实体
     * @return 添加是否成功
     */
    boolean addMsg(MsgRecordEntity entity);

    /**
     * 查询未读消息条数
     * @param userid
     * @return
     */
    int getUnreadMsgCount(Integer userid);

    /**
     * 查用户消息
     * @param pageSize
     * @param start
     * @return
     */
    PageResult getUserMegsResult(int pageSize, int start);

    void updateMsgRecordIsread(Integer msgRecordId, int isread);
}
