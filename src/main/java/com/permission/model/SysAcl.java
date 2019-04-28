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
public class SysAcl {
    private Integer id;

    private String code;

    private String name;

    private Integer aclMoudleId;

    private String url;

    private Integer type;

    private Integer status;

    private Integer seq;

    private String remark;

    private String operator;

    private Date operaterTime;

    private String operaterIp;


}