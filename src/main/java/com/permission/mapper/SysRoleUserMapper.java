package com.permission.mapper;

import com.permission.model.SysRoleUser;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description:
*/
public interface SysRoleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    SysRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}