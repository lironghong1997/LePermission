package com.permission.mapper;


import com.permission.model.SysAclModule;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description:
*/
public interface SysAclModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAclModule record);

    int insertSelective(SysAclModule record);

    SysAclModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAclModule record);

    int updateByPrimaryKey(SysAclModule record);
}