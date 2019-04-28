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
public class SysLog {
    private Integer id;

    private Integer type;

    private Integer targerId;

    private String operator;

    private Date operaterTime;

    private String operaterIp;

    private Integer status;


}