package com.uap.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uap.model.utils.Result;

public class BaseController<M extends IService<T>, T> {
    @Autowired
    protected M baseService;
    @RequestMapping("selectAll")
    @ResponseBody
    public Result<List<T>> selectAll(){
        return Result.success(baseService.list());
    }

    @RequestMapping("select")
    @ResponseBody
    public Result<T> selectByPrimaryKey(Integer id){
        return Result.success(baseService.getById(id));
    }

    @RequestMapping("selectByCondition")
    @ResponseBody
    public Result<List<T>> selectByCondition(Wrapper<T> queryWrapper){
        return Result.success(baseService.list(queryWrapper));
    }

    @RequestMapping("count")
    @ResponseBody
    public Result<Integer> count(Wrapper<T> queryWrapper){
        return Result.success(baseService.count(queryWrapper));
    }

    @RequestMapping("insert")
    @ResponseBody
    public Result<Integer> insertSelective(T record){
        return Result.success(baseService.getBaseMapper().insert(record));
    }

    @RequestMapping("update")
    @ResponseBody
    public Result<Boolean> updateByPrimaryKeySelective(T record){
    	baseService.getBaseMapper().updateById(record);
        return Result.success(true);
    }

    @RequestMapping("selectByPage")
    @ResponseBody
    public Result<IPage<Map<String, Object>>> selectByPage(IPage<T> page,Wrapper<T> queryWrapper){
    	IPage<Map<String, Object>> pagelist = baseService.pageMaps(page, queryWrapper);
 
        return Result.success(pagelist);
    }

    @RequestMapping("deleteByPrimaryKey")
    @ResponseBody
    public Result<Integer> deleteByPrimaryKey(Integer  id){
    	baseService.removeById(id);
        return Result.success(id);
    }
}
