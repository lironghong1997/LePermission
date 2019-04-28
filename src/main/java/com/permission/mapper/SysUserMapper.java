package com.permission.mapper;

import com.permission.model.SysUser;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 
*/
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKeyWithBLOBs(SysUser record);

    int updateByPrimaryKey(SysUser record);
}