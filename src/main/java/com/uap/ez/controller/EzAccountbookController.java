package com.uap.ez.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uap.controller.BaseController;
import com.uap.ez.entity.EzAccountbook;
import com.uap.ez.service.IEzAccountbookService;
import com.uap.model.utils.Page;
import com.uap.model.utils.Result;

/**
 * <p>
 * 日记账表 前端控制器
 * </p>
 *
 * @author xp
 * @since 2019-07-08
 */
@RestController
@RequestMapping("/ez-accountbook")
public class EzAccountbookController extends BaseController<IEzAccountbookService, EzAccountbook> {
//	@Autowired
//    IEzAccountbookService ezAccountbookService;
//
//    @RequestMapping("selectAll")
//    @ResponseBody
//    public Result<List<EzAccountbook>> selectAll(){
//        return Result.success(ezAccountbookService.list());
//    }
//
//    @RequestMapping("select")
//    @ResponseBody
//    public Result<EzAccountbook> selectByPrimaryKey(Integer id){
//        return Result.success(ezAccountbookService.getById(id));
//    }
//
//    @RequestMapping("selectByCondition")
//    @ResponseBody
//    public Result<List<EzAccountbook>> selectByCondition(Wrapper<EzAccountbook> queryWrapper){
//        return Result.success(ezAccountbookService.list(queryWrapper));
//    }
//
//    @RequestMapping("count")
//    @ResponseBody
//    public Result<Integer> count(Wrapper<EzAccountbook> queryWrapper){
//        return Result.success(ezAccountbookService.count(queryWrapper));
//    }
//
//    @RequestMapping("insert")
//    @ResponseBody
//    public Result<Integer> insertSelective(EzAccountbook record){
//        return Result.success(ezAccountbookService.getBaseMapper().insert(record));
//    }
//
//    @RequestMapping("update")
//    @ResponseBody
//    public Result<Boolean> updateByPrimaryKeySelective(EzAccountbook record){
//    	ezAccountbookService.getBaseMapper().updateById(record);
//        return Result.success(true);
//    }
//
//    @RequestMapping("selectByPage")
//    @ResponseBody
//    public Result<IPage<Map<String, Object>>> selectByPage(IPage<EzAccountbook> page,Wrapper<EzAccountbook> queryWrapper){
//    	IPage<Map<String, Object>> pagelist = ezAccountbookService.pageMaps(page, queryWrapper);
// 
//        return Result.success(pagelist);
//    }
//
//    @RequestMapping("deleteByPrimaryKey")
//    @ResponseBody
//    public Result<Integer> deleteByPrimaryKey(Integer  id){
//    	ezAccountbookService.removeById(id);
//        return Result.success(id);
//    }

}
