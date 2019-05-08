package com.permission.mapper;

import com.permission.beans.PageQuery;
import com.permission.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //查询符合分页条件的总条数
    int countByDeptId(@Param("deptid") int deptid);

    List<SysUser> getPageByDeptId(@Param("deptid") Integer deptid, @Param("pageQuery") PageQuery pageQuery);
}