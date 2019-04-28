package com.permission.model;

import lombok.Data;

import java.util.Date;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 
*/
@Data
public class SysRoleAcl {
    private Integer id;

    private Integer roleId;

    private Integer aclId;

    private String operator;

    private Date operaterTime;

    private String operaterIp;


}