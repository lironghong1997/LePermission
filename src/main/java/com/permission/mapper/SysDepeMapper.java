package com.permission.mapper;


import com.permission.model.SysDepe;

import java.util.List;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description:
*/
public interface SysDepeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDepe record);

    int insertSelective(SysDepe record);

    SysDepe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDepe record);

    int updateByPrimaryKey(SysDepe record);

    //获取当前用户的部门列表
    List<SysDepe> getAllDept();
}