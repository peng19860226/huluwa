package com.uap.controller.template;

import com.uap.model.PageResult;
import com.uap.model.utils.ResponseWrapper;
import com.uap.service.MsgRecordsService;
import com.uap.utils.SecurityAuthenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgRecordsController {

    @Autowired
    private MsgRecordsService msgRecordsService;


    @GetMapping("/msgrecords/unreadnum")
    public ResponseWrapper<Integer> getUnreadMsgCount() {
        return new ResponseWrapper<>(msgRecordsService.getUnreadMsgCount(SecurityAuthenUtil.getId()));
    }

    @GetMapping("/msgrecords/user")
    public ResponseWrapper<PageResult> userMesRecordsGet(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult pageResult = msgRecordsService.getUserMegsResult(pageSize, page * pageSize);
        return new ResponseWrapper<>(pageResult);
    }

    @PutMapping("/msgrecords/read")
    public ResponseWrapper<Integer> userReadMes(@RequestParam("msgRecordId") Integer msgRecordId) {
        msgRecordsService.updateMsgRecordIsread(msgRecordId, 1);
        return new ResponseWrapper<Integer>(msgRecordId);
    }

}
