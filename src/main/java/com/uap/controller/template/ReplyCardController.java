package com.uap.controller.template;

import com.uap.model.PageResult;
import com.uap.model.ReplyCardEntity;
import com.uap.model.utils.ResponseWrapper;
import com.uap.service.ReplyCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyCardController {

    @Autowired
    private ReplyCardService replyCardService;

    @GetMapping("/public/replycards")
    public ResponseWrapper<PageResult> replycardList(@RequestParam("postcardid") int postcardid,
                                                     @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult pageResult = new PageResult();
        pageResult.setData(replyCardService.replycardList(postcardid, pageSize, page * pageSize));
        pageResult.setTotalCount(replyCardService.replycardSize(postcardid, pageSize, page * pageSize));
        return new ResponseWrapper<>(pageResult);
    }

    @PostMapping("/replycards/replycard")
    public ResponseWrapper<ReplyCardEntity> insertEntity(@RequestBody ReplyCardEntity replyCardEntity) {
        replyCardService.insertEntity(replyCardEntity);
        return new ResponseWrapper<>(replyCardEntity);
    }

}
