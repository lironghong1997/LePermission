package com.permission.mapper;


import com.permission.model.SysLog;
import com.permission.model.SysLogWithBLOBs;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description:
*/
public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLogWithBLOBs record);

    int insertSelective(SysLogWithBLOBs record);

    SysLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysLogWithBLOBs record);

    int updateByPrimaryKey(SysLog record);
}