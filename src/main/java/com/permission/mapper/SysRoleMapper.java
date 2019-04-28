package com.permission.mapper;


import com.permission.model.SysRole;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description:
*/
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}