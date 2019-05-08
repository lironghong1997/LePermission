package com.permission.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUser {
    private Integer id;

    private String username;

    private String telephone;

    private String mail;

    private String password;

    private Integer deptId;

    private Integer status;

    private String remark;

    private Date operaterTime;

    private String operaterIp;

    private String operator;

}